package com.belaid.demo.service;

import com.belaid.demo.entity.Wallet;
import com.belaid.demo.exception.WalletException;
import com.belaid.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> getAll() {
        return walletRepository.findAllByOrderByPriority();
    }

    public Wallet getById(Long id){
        Optional<Wallet> wallet = walletRepository.findById(id);
        if (wallet.isPresent()) {
            return wallet.get();
        }

        throw new WalletException("Wallet with " + id + " does not exists !!");
    }

    public Wallet createOrUpdate(Wallet wallet) {
        if (wallet.getId() == null) {
            walletRepository.save(wallet);
        } else {
            walletRepository.save(wallet);
        }
        return wallet;
    }

    public Boolean delete(Long id) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        if (wallet.isPresent()) {
            walletRepository.delete(wallet.get());
            return true;
        }

        throw new WalletException("Wallet with " + id + " does not exists !!");
    }
}
