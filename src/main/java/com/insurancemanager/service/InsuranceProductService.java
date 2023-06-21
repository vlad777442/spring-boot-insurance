package com.insurancemanager.service;


import com.insurancemanager.model.InsuranceProduct;

import java.util.List;

public interface InsuranceProductService {
    InsuranceProduct saveClient(InsuranceProduct insuranceProduct);

    List<InsuranceProduct> getAllInsuranceProducts();

    InsuranceProduct getInsuranceProductById(Long id);

    void updateInsuranceProduct(InsuranceProduct insuranceProduct);

    void deleteInsuranceProduct(Long id);
}
