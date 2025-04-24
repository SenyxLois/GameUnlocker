package io.github.rushiranpise.gameunlocker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;
import java.security.KeyStore;
import java.util.Arrays;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

@SuppressLint("DiscouragedPrivateApi")
@SuppressWarnings("ConstantConditions")
public class GAMEUNLOCKER implements IXposedHookLoadPackage {

    // Packages to Spoof as Xiaomi 13 Pro
    private static final String[] packagesToChangeMI13P = {
        "com.levelinfinite.sgameGlobal",
        "com.tencent.tmgp.sgame",
        "com.activision.callofduty.shooter",
        "com.activision.callofudty.warzone",
        "com.ea.gp.fifamobile",
        "com.gameloft.android.ANMP.GloftA9HM",
        "com.madfingergames.legends",
        "com.pearlabyss.blackdesertm",
        "com.pearlabyss.blackdesertm.gl",
        "com.ea.gp.apexlegendsmobilefps",
        "com.mobilelegends.mi",
        "com.levelinfinite.hotta.gp",
        "com.supercell.clashofclans",
        "com.vng.mlbbvn",
        "com.garena.game.codm",
        "com.tencent.tmgp.kr.codm",
        "com.vng.codmvn",
        "com.garena.game.kgvn",
        "com.netease.lztgglobal",
        "com.pubg.imobile",
        "com.pubg.krmobile",
        "com.rekoo.pubgm",
        "com.riotgames.league.wildrift",
        "com.riotgames.league.wildrifttw",
        "com.riotgames.league.wildriftvn",
        "com.riotgames.league.teamfighttactics",
        "com.riotgames.league.teamfighttacticstw",
        "com.riotgames.league.teamfighttacticsvn",
        "com.tencent.ig",
        "com.tencent.tmgp.pubgmhd",
        "com.vng.pubgmobile",
        "vng.games.revelation.mobile",
        "com.ngame.allstar.eu",
        "com.mojang.minecraftpe",
        "com.YoStar.AetherGazer",
        "com.miHoYo.GenshinImpact",
        "com.garena.game.lmjx",
        "com.epicgames.fortnite",
        "com.epicgames.portal",
        "com.tencent.lolm",
        "jp.konami.pesam"
    };

    // Packages to Spoof as POCO F5
    private static final String[] packagesToChangeF5 = {
        "com.dts.freefiremax",
        "com.dts.freefireth",
        "com.mobile.legends"
    };

    // Packages to Spoof as Black Shark 4
    private static final String[] packagesToChangeBS4 = {
        "com.proximabeta.mf.uamo"
    };

    // Packages to Spoof as iQOO 11 Pro
    private static final String[] packagesToChangeiQ11P = {
        "com.tencent.KiHan",
        "com.tencent.tmgp.cf",
        "com.tencent.tmgp.cod",
        "com.tencent.tmgp.gnyx"
    };

    // Testing code from @JeelsBoobz
    private static final String[] packagesToChangeGameMatrix = {
        "com.garena.game.df"
    };

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {

        String packageName = loadPackageParam.packageName;

        // Black Shark
        if (Arrays.asList(packagesToChangeBS4).contains(packageName)) {
            propsToChangeBS4();
            XposedBridge.log("Spoofed " + packageName + " as Black Shark 4");
        }

        // Iqoo
        if (Arrays.asList(packagesToChangeiQ11P).contains(packageName)) {
            propsToChangeiQ11P();
            XposedBridge.log("Spoofed " + packageName + " as iQOO 11 Pro");
        }

        // Poco
        if (Arrays.asList(packagesToChangeF5).contains(packageName)) {
            propsToChangeF5();
            XposedBridge.log("Spoofed " + packageName + " as Poco F5");
        }

        // Xiaomi

        if (Arrays.asList(packagesToChangeMI13P).contains(packageName)) {
            propsToChangeMI13P();
            XposedBridge.log("Spoofed " + packageName + " as Xiaomi Mi 13 Pro");
        }

        // GameMatrix
        if (Arrays.asList(packagesToChangeGameMatrix).contains(packageName)) {
            propsToChangeGameMatrix();
            XposedBridge.log("Spoofed " + packageName + " as GameMatrix");
        }
    }

    // Blackshark
    // Props to Spoof as Blackshark 4
    private static void propsToChangeBS4() {
        setPropValue("MANUFACTURER", "blackshark");
        setPropValue("MODEL", "2SM-X706B");
    }

    // Iqoo
    // Props to Spoof as iQOO 11 Pro
    private static void propsToChangeiQ11P() {
        setPropValue("MANUFACTURER", "vivo");
        setPropValue("MODEL", "V2243A");
    }

    //Poco
    // Props to Spoof as Poco F5
    private static void propsToChangeF5() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "23049PCD8G");
    }

    // Xiaomi

    // Props to Spoof as Xiaomi Mi 13 Pro
    private static void propsToChangeMI13P() {
        setPropValue("MANUFACTURER", "Xiaomi");
        setPropValue("MODEL", "2210132C");
    }

    private static void propsToChangeGameMatrix() {
        setPropValue("MODEL", "gamematrix");
    }

    private static void setPropValue(String key, Object value) {
        try {
            Log.d(TAG, "Defining prop " + key + " to " + value.toString());
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            XposedBridge.log("Failed to set prop: " + key + "\n" + Log.getStackTraceString(e));
        }
    }
}