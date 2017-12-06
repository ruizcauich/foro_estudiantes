/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;

/**
 *
 * @author augusto
 */
public abstract  class Model {
    protected int id;
    protected Conexion connection = new Conexion();
    
    public abstract Model save();
    public abstract ArrayList<Model> getObjects(String[][] atributo_valor);
    public abstract ArrayList<Model> getAllObjects();
    public abstract boolean delete();
    public abstract boolean update();
    
    
    
}
