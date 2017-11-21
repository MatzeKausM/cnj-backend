package edu.hm.cs.cnj.cnjbackend.service;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hm.cs.cnj.cnjbackend.persistence.Teilnahme;
import edu.hm.cs.cnj.cnjbackend.persistence.TeilnahmeStatus;
import edu.hm.cs.cnj.cnjbackend.persistence.Veranstaltung;
import edu.hm.cs.cnj.cnjbackend.persistence.VeranstaltungRepository;

@Service
@Transactional
public class VeranstaltungService {

	@Autowired
	private VeranstaltungRepository repository;
	
	public Long erzeugeVeranstaltung(String titel, String beschreibung, Date beginn) {
		Veranstaltung veranstaltung = new Veranstaltung(titel, beschreibung, beginn);
		repository.save(veranstaltung);		
		return veranstaltung.getId();
	}
	
	public void fuegeTeilnahmeHinzu(long key, String name, int begleiter) {
		Veranstaltung veranstaltung = repository.findOne(key);
		Teilnahme teilnahme = new Teilnahme(name, begleiter);
		veranstaltung.add(teilnahme);
	}
	
	public void sageOffeneTeilnahmenAbBis(Date date) {
		Collection<Veranstaltung> veranstaltungen = repository.findByBeginnBefore(date);
		for (Veranstaltung veranstaltung: veranstaltungen) {
			for (Teilnahme teilnahme: veranstaltung.getTeilnahmen()) {
				if (teilnahme.getStatus()==TeilnahmeStatus.OFFEN) {
					teilnahme.setStatus(TeilnahmeStatus.ABSAGE);
				}
			}
		}
	}
}
