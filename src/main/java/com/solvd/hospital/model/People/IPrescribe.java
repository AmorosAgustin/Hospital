package com.solvd.hospital.model.People;

import com.solvd.hospital.model.Medicine.Medicine;

public interface IPrescribe {

    public abstract void prescribe(Medicine medicine, Patient patient);


}
