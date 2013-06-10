package model;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Observer;
import java.util.Random;

import observer.Observable;

public class Partie {
//public class Model implements Observable {	

	  private String nom;
	  private int point, pointMarque;
	  private int nbreQuest;

	  public Partie(){
		    nom = new String("........");
		    point = 0;
		    nbreQuest = 0;
	  }

	  public Partie(String nom, int point, int numQuest){
		  nom = nom;
		  point = point;
		  nbreQuest = numQuest;
	  }

	  public int getPoint(){
		  return point;
	  }
	  
	  public void initPoint(int nbErreur){
		  switch (nbErreur){

		      case 0:
		          this.point += 1;
		          this.pointMarque = 1;
		          break;
		
		      case 1:
		    	  this.point += 1;
		    	  this.pointMarque = 1;
		          break;
		
		      case 2:
		    	  this.point += 0;
		    	  this.pointMarque = 0;
		          break;
		
		      case 3:
		    	  this.point += 0;
		    	  this.pointMarque = 0;
		          break;
		
		      default:
		    	  this.point += 0;

	      }

	  }

	  public String getNom(){
		  return nom;
	  }
	  
	  public void setNom(String nom){
		  this.nom = (nom != null) ? nom : "........";
	  }

	  public void setNombreQuest(int nbre){
		  this.nbreQuest = nbre;
	  }
	  
	  public int getNombreQuest(){
		  return this.nbreQuest;
	  }
	  
	  public String toString(){
		  return " "+nom+" : "+point+" pts ("+nbreQuest+" question"+((nbreQuest > 1) ? "s" : "")+")";	  
	  }

	  public int getPointMarque(){
		  return pointMarque;
	  }

	}
