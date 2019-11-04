import io.github.juanmuscaria.jmutils.Implementations;
import io.github.juanmuscaria.jmutils.discord.rcp.DiscordRCP;
import io.github.juanmuscaria.jmutils.discord.rcp.struct.DiscordEventHandlers;
import io.github.juanmuscaria.jmutils.discord.rcp.struct.DiscordRichPresence;
import org.junit.Test;

public class TestDiscordSDK {
    //@Test
    public void TestDiscord() {
        DiscordRCP rcp = Implementations.getDiscordRCP();
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.state = "teste1";
        presence.partySize = Integer.MAX_VALUE;
        presence.partyMax = 1;
        presence.partyId = "4352345";
        presence.joinSecret = "segredo";
        presence.spectateSecret = "aaaa";
        presence.details = ".................";
        DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        eventHandlers.ready = request -> {
            rcp.Discord_UpdatePresence(presence);
            System.out.println("a");
        };
        rcp.Discord_Initialize("636953971117916160", eventHandlers, 1, "");
        rcp.Discord_Register("636953971117916160", "");
        while (true) {
            rcp.Discord_RunCallbacks();
        }
    }

    @Test
    public void teste1() {
        System.out.println((int) "Ω".toCharArray()[0]);
    }
}
