package gioelefriggia.sassariSoccorso.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "checklist_mezzo")
public class ChecklistMezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private String time;

    @Column(name = "ambulance")
    private String ambulance;

    @Column(name = "plate")
    private String plate;

    @Column(name = "initial_km")
    private int initialKm;

    @Column(name = "fuel_level")
    private double fuelLevel;

    @Column(name = "motor_oil_level")
    private double motorOilLevel;

    @Column(name = "coolant_level")
    private double coolantLevel;

    @Column(name = "brake_fluid_level")
    private double brakeFluidLevel;

    @Column(name = "steering_fluid_level")
    private double steeringFluidLevel;

    @Column(name = "electrical_system")
    private boolean electricalSystem;

    @Column(name = "warning_lights")
    private boolean warningLights;

    @Column(name = "front_lights")
    private String frontLights;

    @Column(name = "rear_lights")
    private String rearLights;

    @Column(name = "right_side_lights")
    private String rightSideLights;

    @Column(name = "left_side_lights")
    private String leftSideLights;

    @Column(name = "component_equipe")
    private String componenteqipe;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(String ambulance) {
        this.ambulance = ambulance;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getInitialKm() {
        return initialKm;
    }

    public void setInitialKm(int initialKm) {
        this.initialKm = initialKm;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getMotorOilLevel() {
        return motorOilLevel;
    }

    public void setMotorOilLevel(double motorOilLevel) {
        this.motorOilLevel = motorOilLevel;
    }

    public double getCoolantLevel() {
        return coolantLevel;
    }

    public void setCoolantLevel(double coolantLevel) {
        this.coolantLevel = coolantLevel;
    }

    public double getBrakeFluidLevel() {
        return brakeFluidLevel;
    }

    public void setBrakeFluidLevel(double brakeFluidLevel) {
        this.brakeFluidLevel = brakeFluidLevel;
    }

    public double getSteeringFluidLevel() {
        return steeringFluidLevel;
    }

    public void setSteeringFluidLevel(double steeringFluidLevel) {
        this.steeringFluidLevel = steeringFluidLevel;
    }

    public boolean isElectricalSystem() {
        return electricalSystem;
    }

    public void setElectricalSystem(boolean electricalSystem) {
        this.electricalSystem = electricalSystem;
    }

    public boolean isWarningLights() {
        return warningLights;
    }

    public void setWarningLights(boolean warningLights) {
        this.warningLights = warningLights;
    }

    public String getFrontLights() {
        return frontLights;
    }

    public void setFrontLights(String frontLights) {
        this.frontLights = frontLights;
    }

    public String getRearLights() {
        return rearLights;
    }

    public void setRearLights(String rearLights) {
        this.rearLights = rearLights;
    }

    public String getRightSideLights() {
        return rightSideLights;
    }

    public void setRightSideLights(String rightSideLights) {
        this.rightSideLights = rightSideLights;
    }

    public String getLeftSideLights() {
        return leftSideLights;
    }

    public void setLeftSideLights(String leftSideLights) {
        this.leftSideLights = leftSideLights;
    }

    public String getCabinFeatures() {
        return componenteqipe;
    }

    public void setCabinFeatures(String cabinFeatures) {
        this.componenteqipe = cabinFeatures;
    }
}
