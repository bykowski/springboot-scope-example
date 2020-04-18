package pl.bykowski.springbootscopeexample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    @Autowired
    private GameConfig gameConfig;

    @GetMapping("/config")
    public String getConfig(Model model) {
        model.addAttribute("gameConfig", gameConfig);
        return "config";
    }

    @GetMapping("/game")
    public String getGame(Model model) {
        model.addAttribute("gameConfig", gameConfig);
        return "game";
    }

    @PostMapping("/**")
    public String get(String bgColor, String playerColor, int difficult) {
        gameConfig.setBgColor(bgColor);
        gameConfig.setPlayerColor(playerColor);
        gameConfig.setDifficult(difficult);
        return "redirect:/config";
    }

}
