package gioelefriggia.sassariSoccorso.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "checklist_vano_sanitario")
public class ChecklistVanoSanitario {

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

    @Column(name = "team")
    private String team;

    @Column(name = "zaino_rosso")
    private boolean zainoRosso;

    @Column(name = "soluzione_fisiologica")
    private boolean soluzioneFisiologica;

    @Column(name = "zaino_pediatrico")
    private boolean zainoPediatrico;

    @Column(name = "sacca_i")
    private boolean saccaI;

    @Column(name = "sacca_iv")
    private boolean saccaIV;

    @Column(name = "ambu_pediatrico")
    private boolean ambuPediatrico;

    @Column(name = "ambu_neonatale")
    private boolean ambuNeonatale;

    @Column(name = "sfigmomanometro")
    private boolean sfigmomanometro;

    @Column(name = "pulsiosimetro")
    private boolean pulsiosimetro;

    @Column(name = "termometro")
    private boolean termometro;

    @Column(name = "sacca_ii")
    private boolean saccaII;

    @Column(name = "lenzuolino_isotermico")
    private boolean lenzuolinoIsotermico;

    @Column(name = "fogli_rifiuto")
    private boolean fogliRifiuto;

    @Column(name = "telini_sterili")
    private boolean teliniSterili;

    @Column(name = "forbici_robin")
    private boolean forbiciRobin;

    @Column(name = "sacca_iii")
    private boolean saccaIII;

    @Column(name = "forbice_pinze")
    private boolean forbicePinze;

    @Column(name = "garze_sterili")
    private boolean garzeSterili;

    @Column(name = "laccio_emostatico")
    private boolean laccioEmostatico;

    @Column(name = "benda_orlata")
    private boolean bendaOrlata;

    @Column(name = "cerotti")
    private boolean cerotti;

    @Column(name = "acqua_ossigenata")
    private boolean acquaOssigenata;

    @Column(name = "sacca_sportello_dx")
    private boolean saccaSportelloDX;

    @Column(name = "maschere_ffp2")
    private boolean maschereFFP2;

    @Column(name = "dae")
    private boolean dae;

    @Column(name = "piastre")
    private boolean piastre;

    @Column(name = "lamette")
    private boolean lamette;

    @Column(name = "tavola_spinale")
    private boolean tavolaSpinale;

    @Column(name = "cinghie_ragno")
    private boolean cinghieRagno;

    @Column(name = "fermacapo")
    private boolean fermacapo;

    @Column(name = "ked")
    private boolean ked;

    @Column(name = "barella_traumatica")
    private boolean barellaTraumatica;

    @Column(name = "stecco_bende")
    private boolean steccoBende;

    @Column(name = "collari_cervicali")
    private boolean collariCervicali;

    @Column(name = "umidificatore")
    private boolean umidificatore;

    @Column(name = "maschera_reservoir")
    private boolean mascheraReservoir;

    @Column(name = "occhialini_o2")
    private boolean occhialiniO2;

    @Column(name = "livello_bombola1")
    private String livelloBombola1;

    @Column(name = "livello_bombola2")
    private String livelloBombola2;

    @Column(name = "aspiratore_portatile")
    private boolean aspiratorePortatile;

    @Column(name = "guanti_lattice_s")
    private boolean guantiLatticeS;

    @Column(name = "guanti_lattice_m")
    private boolean guantiLatticeM;

    @Column(name = "guanti_lattice_l")
    private boolean guantiLatticeL;

    @Column(name = "kit_recupero_arti")
    private boolean kitRecuperoArti;

    @Column(name = "buste_mondezza")
    private boolean busteMondezza;

    @Column(name = "rotolo_carta")
    private boolean rotoloCarta;

    @Column(name = "padella_pappagallo")
    private boolean padellaPappagallo;

    @Column(name = "sacchetti_vomito")
    private boolean sacchettiVomito;

    @Column(name = "note")
    private String note;

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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isZainoRosso() {
        return zainoRosso;
    }

    public void setZainoRosso(boolean zainoRosso) {
        this.zainoRosso = zainoRosso;
    }

    public boolean isSoluzioneFisiologica() {
        return soluzioneFisiologica;
    }

    public void setSoluzioneFisiologica(boolean soluzioneFisiologica) {
        this.soluzioneFisiologica = soluzioneFisiologica;
    }

    public boolean isZainoPediatrico() {
        return zainoPediatrico;
    }

    public void setZainoPediatrico(boolean zainoPediatrico) {
        this.zainoPediatrico = zainoPediatrico;
    }

    public boolean isSaccaI() {
        return saccaI;
    }

    public void setSaccaI(boolean saccaI) {
        this.saccaI = saccaI;
    }

    public boolean isSaccaIV() {
        return saccaIV;
    }

    public void setSaccaIV(boolean saccaIV) {
        this.saccaIV = saccaIV;
    }

    public boolean isAmbuPediatrico() {
        return ambuPediatrico;
    }

    public void setAmbuPediatrico(boolean ambuPediatrico) {
        this.ambuPediatrico = ambuPediatrico;
    }

    public boolean isAmbuNeonatale() {
        return ambuNeonatale;
    }

    public void setAmbuNeonatale(boolean ambuNeonatale) {
        this.ambuNeonatale = ambuNeonatale;
    }

    public boolean isSfigmomanometro() {
        return sfigmomanometro;
    }

    public void setSfigmomanometro(boolean sfigmomanometro) {
        this.sfigmomanometro = sfigmomanometro;
    }

    public boolean isPulsiosimetro() {
        return pulsiosimetro;
    }

    public void setPulsiosimetro(boolean pulsiosimetro) {
        this.pulsiosimetro = pulsiosimetro;
    }

    public boolean isTermometro() {
        return termometro;
    }

    public void setTermometro(boolean termometro) {
        this.termometro = termometro;
    }

    public boolean isSaccaII() {
        return saccaII;
    }

    public void setSaccaII(boolean saccaII) {
        this.saccaII = saccaII;
    }

    public boolean isLenzuolinoIsotermico() {
        return lenzuolinoIsotermico;
    }

    public void setLenzuolinoIsotermico(boolean lenzuolinoIsotermico) {
        this.lenzuolinoIsotermico = lenzuolinoIsotermico;
    }

    public boolean isFogliRifiuto() {
        return fogliRifiuto;
    }

    public void setFogliRifiuto(boolean fogliRifiuto) {
        this.fogliRifiuto = fogliRifiuto;
    }

    public boolean isTeliniSterili() {
        return teliniSterili;
    }

    public void setTeliniSterili(boolean teliniSterili) {
        this.teliniSterili = teliniSterili;
    }

    public boolean isForbiciRobin() {
        return forbiciRobin;
    }

    public void setForbiciRobin(boolean forbiciRobin) {
        this.forbiciRobin = forbiciRobin;
    }

    public boolean isSaccaIII() {
        return saccaIII;
    }

    public void setSaccaIII(boolean saccaIII) {
        this.saccaIII = saccaIII;
    }

    public boolean isForbicePinze() {
        return forbicePinze;
    }

    public void setForbicePinze(boolean forbicePinze) {
        this.forbicePinze = forbicePinze;
    }

    public boolean isGarzeSterili() {
        return garzeSterili;
    }

    public void setGarzeSterili(boolean garzeSterili) {
        this.garzeSterili = garzeSterili;
    }

    public boolean isLaccioEmostatico() {
        return laccioEmostatico;
    }

    public void setLaccioEmostatico(boolean laccioEmostatico) {
        this.laccioEmostatico = laccioEmostatico;
    }

    public boolean isBendaOrlata() {
        return bendaOrlata;
    }

    public void setBendaOrlata(boolean bendaOrlata) {
        this.bendaOrlata = bendaOrlata;
    }

    public boolean isCerotti() {
        return cerotti;
    }

    public void setCerotti(boolean cerotti) {
        this.cerotti = cerotti;
    }

    public boolean isAcquaOssigenata() {
        return acquaOssigenata;
    }

    public void setAcquaOssigenata(boolean acquaOssigenata) {
        this.acquaOssigenata = acquaOssigenata;
    }

    public boolean isSaccaSportelloDX() {
        return saccaSportelloDX;
    }

    public void setSaccaSportelloDX(boolean saccaSportelloDX) {
        this.saccaSportelloDX = saccaSportelloDX;
    }

    public boolean isMaschereFFP2() {
        return maschereFFP2;
    }

    public void setMaschereFFP2(boolean maschereFFP2) {
        this.maschereFFP2 = maschereFFP2;
    }

    public boolean isDae() {
        return dae;
    }

    public void setDae(boolean dae) {
        this.dae = dae;
    }

    public boolean isPiastre() {
        return piastre;
    }

    public void setPiastre(boolean piastre) {
        this.piastre = piastre;
    }

    public boolean isLamette() {
        return lamette;
    }

    public void setLamette(boolean lamette) {
        this.lamette = lamette;
    }

    public boolean isTavolaSpinale() {
        return tavolaSpinale;
    }

    public void setTavolaSpinale(boolean tavolaSpinale) {
        this.tavolaSpinale = tavolaSpinale;
    }

    public boolean isCinghieRagno() {
        return cinghieRagno;
    }

    public void setCinghieRagno(boolean cinghieRagno) {
        this.cinghieRagno = cinghieRagno;
    }

    public boolean isFermacapo() {
        return fermacapo;
    }

    public void setFermacapo(boolean fermacapo) {
        this.fermacapo = fermacapo;
    }

    public boolean isKed() {
        return ked;
    }

    public void setKed(boolean ked) {
        this.ked = ked;
    }

    public boolean isBarellaTraumatica() {
        return barellaTraumatica;
    }

    public void setBarellaTraumatica(boolean barellaTraumatica) {
        this.barellaTraumatica = barellaTraumatica;
    }

    public boolean isSteccoBende() {
        return steccoBende;
    }

    public void setSteccoBende(boolean steccoBende) {
        this.steccoBende = steccoBende;
    }

    public boolean isCollariCervicali() {
        return collariCervicali;
    }

    public void setCollariCervicali(boolean collariCervicali) {
        this.collariCervicali = collariCervicali;
    }

    public boolean isUmidificatore() {
        return umidificatore;
    }

    public void setUmidificatore(boolean umidificatore) {
        this.umidificatore = umidificatore;
    }

    public boolean isMascheraReservoir() {
        return mascheraReservoir;
    }

    public void setMascheraReservoir(boolean mascheraReservoir) {
        this.mascheraReservoir = mascheraReservoir;
    }

    public boolean isOcchialiniO2() {
        return occhialiniO2;
    }

    public void setOcchialiniO2(boolean occhialiniO2) {
        this.occhialiniO2 = occhialiniO2;
    }

    public String getLivelloBombola1() {
        return livelloBombola1;
    }

    public void setLivelloBombola1(String livelloBombola1) {
        this.livelloBombola1 = livelloBombola1;
    }

    public String getLivelloBombola2() {
        return livelloBombola2;
    }

    public void setLivelloBombola2(String livelloBombola2) {
        this.livelloBombola2 = livelloBombola2;
    }

    public boolean isAspiratorePortatile() {
        return aspiratorePortatile;
    }

    public void setAspiratorePortatile(boolean aspiratorePortatile) {
        this.aspiratorePortatile = aspiratorePortatile;
    }

    public boolean isGuantiLatticeS() {
        return guantiLatticeS;
    }

    public void setGuantiLatticeS(boolean guantiLatticeS) {
        this.guantiLatticeS = guantiLatticeS;
    }

    public boolean isGuantiLatticeM() {
        return guantiLatticeM;
    }

    public void setGuantiLatticeM(boolean guantiLatticeM) {
        this.guantiLatticeM = guantiLatticeM;
    }

    public boolean isGuantiLatticeL() {
        return guantiLatticeL;
    }

    public void setGuantiLatticeL(boolean guantiLatticeL) {
        this.guantiLatticeL = guantiLatticeL;
    }

    public boolean isKitRecuperoArti() {
        return kitRecuperoArti;
    }

    public void setKitRecuperoArti(boolean kitRecuperoArti) {
        this.kitRecuperoArti = kitRecuperoArti;
    }

    public boolean isBusteMondezza() {
        return busteMondezza;
    }

    public void setBusteMondezza(boolean busteMondezza) {
        this.busteMondezza = busteMondezza;
    }

    public boolean isRotoloCarta() {
        return rotoloCarta;
    }

    public void setRotoloCarta(boolean rotoloCarta) {
        this.rotoloCarta = rotoloCarta;
    }

    public boolean isPadellaPappagallo() {
        return padellaPappagallo;
    }

    public void setPadellaPappagallo(boolean padellaPappagallo) {
        this.padellaPappagallo = padellaPappagallo;
    }

    public boolean isSacchettiVomito() {
        return sacchettiVomito;
    }

    public void setSacchettiVomito(boolean sacchettiVomito) {
        this.sacchettiVomito = sacchettiVomito;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
