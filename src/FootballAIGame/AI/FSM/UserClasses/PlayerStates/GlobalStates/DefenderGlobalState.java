package FootballAIGame.AI.FSM.UserClasses.PlayerStates.GlobalStates;

import FootballAIGame.AI.FSM.UserClasses.Entities.Player;
import FootballAIGame.AI.FSM.UserClasses.Messaging.Message;
import FootballAIGame.AI.FSM.UserClasses.PlayerStates.PlayerState;

public class DefenderGlobalState extends PlayerState {
    
    private FieldPlayerGlobalState fieldPlayerGlobalState;
    
    public DefenderGlobalState(Player player) {
        super(player);
        fieldPlayerGlobalState = new FieldPlayerGlobalState(player);
    }
    
    @Override
    public void run() {
        fieldPlayerGlobalState.run();
    }
    
    @Override
    public boolean processMessage(Message message) {
        return fieldPlayerGlobalState.processMessage(message);
    }
}
