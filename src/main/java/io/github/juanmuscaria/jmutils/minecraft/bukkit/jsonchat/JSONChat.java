package io.github.juanmuscaria.jmutils.minecraft.bukkit.jsonchat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;


@Deprecated
public class JSONChat {
    private JsonObject jsonObject = new JsonObject();

    public JSONChat() {
        jsonObject.addProperty("text", "");
        JsonArray text = new JsonArray();
        jsonObject.add("extra", text);
    }

    public JSONChat addText(JsonObject text) {
        jsonObject.getAsJsonArray("extra").add(text);
        return this;
    }

    public JSONChat addText(@NotNull Text text) {
        jsonObject.getAsJsonArray("extra").add(text.toJson());
        return this;
    }

}

