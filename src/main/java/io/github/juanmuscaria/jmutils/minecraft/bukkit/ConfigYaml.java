package io.github.juanmuscaria.jmutils.minecraft.bukkit;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * A simple wrapper for bukkit YamlConfiguration api.
 */
public final class ConfigYaml {

    private final File configFile;
    private YamlConfiguration yamlConfiguration = null;

    /**
     * Create a new configuration file.
     *
     * @param configFile The file that will be used.
     */
    public ConfigYaml(File configFile) {
        this.configFile = Objects.requireNonNull(configFile,"Config file cannot be null.");
        reloadConfig();
    }


    /**
     * Reload configuration file.
     */
    public void reloadConfig() {
        yamlConfiguration = YamlConfiguration.loadConfiguration(configFile);
        save();
    }

    /**
     * Saves the configuration file to disk.
     */
    public void save() {
        if (yamlConfiguration == null) {
            return;
        }
        try {
            yamlConfiguration.save(configFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Get the YamlConfiguration.
     *
     * @return The YamlConfiguration.
     */
    public YamlConfiguration getYaml() {
        if (yamlConfiguration == null) {
            reloadConfig();
        }
        return yamlConfiguration;
    }

    /**
     * Get the Configuration File.
     *
     * @return The Configuration File.
     */
    public File getFile(){
        return configFile;
    }

    public void resetData(){
        yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.save(configFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
