package com.footballaigame.client.ais.fsm.steeringbehaviors;

import com.footballaigame.client.customdatatypes.Vector;
import com.footballaigame.client.simulationentities.MovableEntity;
import com.footballaigame.client.ais.fsm.entities.Player;

public class Evade extends SteeringBehavior {
    
    private Flee fleeFromTarget;
    
    public MovableEntity target;
    
    public double getSafeDistance() {
        return fleeFromTarget.safeDistance;
    }
    
    public void setSafeDistance(double value) {
        fleeFromTarget.safeDistance = value;
    }
    
    public Evade(Player player, int priority, double weight, MovableEntity target, double safeDistance) {
        super(player, priority, weight);
        this.target = target;
        fleeFromTarget = new Flee(player, priority, weight, target.position, safeDistance);
    }
    
    @Override
    public Vector getAccelerationVector() {
        
        double distance = Vector.getDistanceBetween(player.position, target.position);
        
        double lookAheadTime = 0;
        if (player.getCurrentSpeed() + target.getCurrentSpeed() > 0)
            lookAheadTime = distance / (player.getCurrentSpeed() + target.getCurrentSpeed());
        
        Vector predictedPosition = Vector.getSum(target.position,
                target.movement.getMultiplied(lookAheadTime));
        
        fleeFromTarget.from = predictedPosition;
        
        return fleeFromTarget.getAccelerationVector();
    }
}