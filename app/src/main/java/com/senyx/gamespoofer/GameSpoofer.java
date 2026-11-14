package com.senyx.gamespoofer;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import java.lang.reflect.Field;
import java.util.Arrays;

import io.github.libxposed.api.XposedModule;

@SuppressLint("DiscouragedPrivateApi")
public class GameSpoofer extends XposedModule {

    private static final String TAG = "GameSpoofer";

    // Packages to Spoof as POCO F9 Ultra (songyang.prop)
    private static final String[] packagesToChangePocoF9Ultra = {
        "com.mobile.legends",
        "com.mobilelegends.mi",
        "com.vng.mlbbvn",
        "com.activision.callofduty.shooter",
        "com.garena.game.codm",
        "com.tencent.tmgp.kr.codm",
        "com.vng.codmvn",
        "com.hermes.p6gameos",
        "com.garena.game.lmjx"
    };

    // Packages to Spoof as OnePlus 15 (oneplus15.prop)
    private static final String[] packagesToChangeOnePlus15 = {
        "com.levelinfinite.sgameGlobal",
        "com.levelinfinite.sgameGlobal.samsung",
        "com.tencent.tmgp.sgame",
        "com.tencent.tmgp.pubgmhd",
        "com.tencent.tmgp.cod",
        "com.tencent.KiHan",
        "com.tencent.tmgp.cf",
        "com.tencent.tmgp.gnyx",
        "com.miHoYo.GenshinImpact"
    };

    // Packages to Spoof as Infinix GT 50 PRO (kingfinix.prop)
    private static final String[] packagesToChangeInfinixGT50Pro = {
        "com.dts.freefiremax",
        "com.dts.freefireth"
    };

    // Packages to Spoof as REDMAGIC 11S Pro (nx809j.prop)
    private static final String[] packagesToChangeRedMagic11SPro = {
        "com.tencent.ig",
        "com.pubg.imobile",
        "com.pubg.krmobile",
        "com.rekoo.pubgm",
        "com.vng.pubgmobile",
        "com.riotgames.league.wildrift",
        "com.riotgames.league.wildrifttw",
        "com.riotgames.league.wildriftvn",
        "com.tencent.lolm",
        "com.riotgames.league.teamfighttactics",
        "com.riotgames.league.teamfighttacticstw",
        "com.riotgames.league.teamfighttacticsvn",
        "com.epicgames.fortnite",
        "com.epicgames.portal",
        "com.gryphline.endfield.gp",
        "com.levelinfinite.hotta.gp",
        "com.YoStar.AetherGazer",
        "com.gameloft.android.ANMP.GloftA9HM",
        "com.madfingergames.legends",
        "com.netease.lztgglobal",
        "com.mojang.minecraftpe",
        "com.ea.gp.apexlegendsmobilefps",
        "com.proximabeta.mf.uamo",
        "com.garena.game.df",
        "com.ngame.allstar.eu",
        "com.garena.game.kgvn",
        "com.sega.pjsekai"
    };

    // Packages to Spoof as Xiaomi 18 Pro Max (madrid.prop)
    private static final String[] packagesToChangeXiaomi18ProMax = {
        "com.activision.callofudty.warzone",
        "com.ea.gp.fifamobile",
        "jp.konami.pesam",
        "com.pearlabyss.blackdesertm",
        "com.pearlabyss.blackdesertm.gl",
        "vng.games.revelation.mobile",
        "com.supercell.clashofclans"
    };

    public GameSpoofer() {
        super();
    }

    @Override
    public void onPackageLoaded(@NonNull PackageLoadedParam param) {
        String packageName = param.getPackageName();

        if (Arrays.asList(packagesToChangePocoF9Ultra).contains(packageName)) {
            spoofDevice("POCO", "songyuan", "Xiaomi", "26077PC53G", "songyuan_global");
            Log.i(TAG, "Spoofed " + packageName + " as POCO F9 Ultra");
        } else if (Arrays.asList(packagesToChangeOnePlus15).contains(packageName)) {
            spoofDevice("OnePlus", "OP611FL1", "OnePlus", "CPH2747", "CPH2747");
            Log.i(TAG, "Spoofed " + packageName + " as OnePlus 15");
        } else if (Arrays.asList(packagesToChangeInfinixGT50Pro).contains(packageName)) {
            spoofDevice("Infinix", "Infinix-X6891", "INFINIX", "Infinix X6891", "X6891");
            Log.i(TAG, "Spoofed " + packageName + " as Infinix GT 50 PRO");
        } else if (Arrays.asList(packagesToChangeRedMagic11SPro).contains(packageName)) {
            spoofDevice("REDMAGIC", "NX809J", "nubia", "NX809J", "NX809J-EEA");
            Log.i(TAG, "Spoofed " + packageName + " as REDMAGIC 11S Pro");
        } else if (Arrays.asList(packagesToChangeXiaomi18ProMax).contains(packageName)) {
            spoofDevice("Xiaomi", "madrid", "Xiaomi", "M154FF", "madrid");
            Log.i(TAG, "Spoofed " + packageName + " as Xiaomi 18 Pro Max");
        }
    }

    private static void spoofDevice(String brand, String device, String manufacturer, String model, String product) {
        if (brand != null) setPropValue("BRAND", brand);
        if (device != null) setPropValue("DEVICE", device);
        if (manufacturer != null) setPropValue("MANUFACTURER", manufacturer);
        if (model != null) setPropValue("MODEL", model);
        if (product != null) setPropValue("PRODUCT", product);
    }

    private static void setPropValue(String key, Object value) {
        try {
            Log.d(TAG, "Defining prop " + key + " to " + value.toString());
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.e(TAG, "Failed to set prop: " + key + "\n" + Log.getStackTraceString(e));
        }
    }
}
