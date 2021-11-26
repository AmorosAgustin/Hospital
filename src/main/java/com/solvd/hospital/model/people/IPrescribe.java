package com.solvd.hospital.model.people;

import com.solvd.hospital.model.medicine.Medicine;

public interface IPrescribe {

    void prescribe(Medicine medicine, Patient patient);


}
