package com.il0v3dorayaki.demo.wallet;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    List<Wallet> walletList = new ArrayList<>();

    public WalletController() {
        Wallet tempWallet1 = new Wallet(1001,"Shinonome Nano", "SAVING", 5000d);
        Wallet tempWallet2 = new Wallet(1002,"Kamisato Ayaka", "SAVING", 7500d);
        walletList.add(tempWallet1);
        walletList.add(tempWallet2);
    }

    @GetMapping("")
    public List<Wallet> getWallets() {
        return walletList;
    }

    @PostMapping("")
    public Wallet createWallet(@Valid @RequestBody Wallet wallet) {
        return wallet;
    }

}
