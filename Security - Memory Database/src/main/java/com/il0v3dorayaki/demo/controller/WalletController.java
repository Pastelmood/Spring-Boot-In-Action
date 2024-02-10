package com.il0v3dorayaki.demo.controller;

import com.il0v3dorayaki.demo.entity.Wallet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    List<Wallet> walletList = new ArrayList<>();

    public WalletController() {
        Wallet tempWallet1 = new Wallet("Shinonome", 5000);
        Wallet tempWallet2 = new Wallet("Ayaka", 10000);
        walletList.add(tempWallet1);
        walletList.add(tempWallet2);
    }

    @GetMapping()
    public List<Wallet> getWallets() {
        return walletList;
    }

    @PostMapping()
    public Wallet createWallet(@RequestBody Wallet newWallet) {
        return newWallet;
    }

}
