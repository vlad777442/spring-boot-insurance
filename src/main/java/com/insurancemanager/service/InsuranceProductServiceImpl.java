package com.insurancemanager.service;

import com.insurancemanager.exception.InsuranceProductNotFoundException;
import com.insurancemanager.model.InsuranceProduct;
import com.insurancemanager.repository.InsuranceProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceProductServiceImpl implements InsuranceProductService {
    @Autowired
    private InsuranceProductRepository insuranceProductRepository;
    @Override
    public InsuranceProduct saveClient(InsuranceProduct insuranceProduct) {
        return insuranceProductRepository.save(insuranceProduct);
    }

    @Override
    public List<InsuranceProduct> getAllInsuranceProducts() {
        return insuranceProductRepository.findAll();
    }

    @Override
    public InsuranceProduct getInsuranceProductById(Long id) {
        Optional<InsuranceProduct> optional = insuranceProductRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new InsuranceProductNotFoundException("InsuranceProduct with Id : \"+id+\" Not Found");
        }
    }

    @Override
    public void updateInsuranceProduct(InsuranceProduct insuranceProduct) {
        insuranceProductRepository.save(insuranceProduct);
    }

    @Override
    public void deleteInsuranceProduct(Long id) {
        insuranceProductRepository.delete(getInsuranceProductById(id));
    }
}
