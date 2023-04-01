package powpaw.config;

import org.yaml.snakeyaml.Yaml;

import javafx.scene.input.KeyCode;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    private final static String YAMLNAME = "keyinput.yaml";
    private Map<Integer, Map<String, KeyCode>> commands = new HashMap<>();

    private Yaml yaml = new Yaml();
    private InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(YAMLNAME);

    public Parser() {
        Map<Integer, Map<String, String>> stringCommands = yaml.load(inputStream);

        stringCommands.entrySet().forEach(e -> {
            this.commands.put(e.getKey(), new HashMap<>());
            e.getValue().entrySet()
                    .forEach(t -> this.commands.get(e.getKey()).put(t.getKey(), KeyCode.valueOf(t.getValue())));
        });

    }

    public Map<String, KeyCode> getCommands(int playerNumber) {
        return this.commands.get(playerNumber);
    }

}
