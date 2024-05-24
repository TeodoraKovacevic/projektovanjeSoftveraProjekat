/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author teodo
 */
public abstract class GenericEntity implements Serializable{

    public abstract String getTableName();

    public abstract String getColumnNameForInsert();

    public abstract String getInserValues();

    public abstract void setId(Long id);
    
    public abstract List<GenericEntity> dodajNovi(ResultSet rs)throws Exception;

    public abstract String getJoinTable();

    public abstract String getKriterijumZaJoin();

    public abstract String getKriterijumZaJednog();

    public abstract GenericEntity dodajJednog(ResultSet rs) throws Exception;
    
    public abstract String getKriterijumZaBrisanje();
    
    public abstract String getAlijas();
    public abstract String getVrednostZaEdit();
    public abstract String getPrimarniKljuc();

    public abstract String getJoinText();

    
}
