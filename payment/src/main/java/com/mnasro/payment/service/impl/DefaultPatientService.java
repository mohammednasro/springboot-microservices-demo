package com.mnasro.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnasro.payment.dto.PatientDTO;
import com.mnasro.payment.proxy.PatientProxy;
import com.mnasro.payment.service.PatientService;

@Service(value = "patientService")
public class DefaultPatientService implements PatientService {

	@Autowired
	private PatientProxy patientProxy;

	@Override
	public PatientDTO getById(long id) {
		return patientProxy.getById(id);
	}

	@Override
	public boolean isExistById(long id) {
		try
		{
			PatientDTO patientDTO = patientProxy.getById(id);
			if(patientDTO==null ||patientDTO.getId()==null)
			{
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
