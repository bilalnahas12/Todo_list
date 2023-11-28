package com.example.todo_l.Module;


import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private String titre;
    private String description;
    private Date date_debut;
    private Date date_fin;

    private Proprieter prp;

    public Task( String titre,String description,Date date_debut,Date date_fin,Proprieter prp){
        this.titre=titre;
        this.description=description;
        this.date_debut=date_debut;
        this.date_fin=date_fin;
        this.prp=prp;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public Proprieter getPrp() {
        return prp;
    }

    public void setPrp(Proprieter prp) {
        this.prp = prp;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public boolean equalTo(Task t){
       if (this.titre == t.getTitre()&&this.date_fin==t.getDate_fin()&&this.date_debut==t.getDate_debut()&&this.description==t.getDescription()){
           return true;
       }
        return false;
    }
}
