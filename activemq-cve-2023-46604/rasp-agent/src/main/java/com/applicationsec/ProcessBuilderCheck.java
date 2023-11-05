package com.applicationsec;

import java.util.Collections;
import java.util.List;

public class ProcessBuilderCheck implements SecurityCheck {

    private static final List<String> blockedCommands = List.of("calc", "etc", "var", "opt", "apache", "bin", "passwd", "login", "cshrc", "profile", "ifconfig", "tcpdump", "chmod",
            "cron", "open", "sudo", "su", "rm", "wget", "sz", "kill", "apt-get", "find", "touch");

    @Override
    public void check(List<String> commands) {
        if( !Collections.disjoint(commands, blockedCommands)){
            throw new RASPSecurityException("Commands :" +commands +" has been blocked by RASP");
        }
    }
}
