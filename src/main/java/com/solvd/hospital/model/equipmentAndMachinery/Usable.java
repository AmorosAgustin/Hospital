package com.solvd.hospital.model.equipmentAndMachinery;

import com.solvd.hospital.model.exception.MachineryBrokenException;

public interface Usable {
    void use() throws MachineryBrokenException;

    void stopUsing() throws MachineryBrokenException;

}
