package com.mussees.go.azzerrifi.gomusees.service;

import com.mussees.go.azzerrifi.gomusees.data.Musee;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Apparicio
 */
public class SearchMuseeHandler extends DefaultHandler {

    private boolean isMusee = false;

    private List<Musee> listMusee = new ArrayList<Musee>();

    private Musee currentMusee;

    private String st;

    private boolean isArtist;

    /**
     * Restitue la liste des albums.
     *
     * @return
     */
    public List<Musee> getListMusee() {
        return listMusee;
    }

    /**
     * Creation d'un album et ajout à la liste
     */
    private Musee createMusee() {
        Musee musee = new Musee();
        listMusee.add(musee);
        return musee;
    }

    /**
     * Creation d'un artiste et ajout à la liste
     */

 /* private Artist createArtist() {
    return new Artist();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
   * java.lang.String, java.lang.String, org.xml.sax.Attributes)
   */
    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes) throws SAXException {
        if ("musee".equals(localName)) {
            isMusee = true;
            currentMusee = createMusee();
        }

    }

    /*
     * (non-Javadoc) BufferedReader
     *
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("musee".equals(localName)) {
            isMusee = false;
        }
  /*

      private String adresse;
      private int cp;
      private String ville;
      private String siteWeb;
      private String fermetureAnnuelle;
      private String periodeOuverture;
      private String jNocturnes;
      */


        else if ("region".equals(localName)) {
            currentMusee.setRegion(st);
        } else if ("departement".equals(localName) && isMusee) {
            currentMusee.setDepartement(st);
        } else if ("dateAppelation".equals(localName) && isMusee) {
            currentMusee.setDateAppelation(st);
        } else if ("ferme".equals(localName) && isMusee) {
            currentMusee.setFerme(st);
        } else if ("anneeReouv".equals(localName) && isMusee) {
            currentMusee.setAnneeReouv(st);
        } else if ("nom".equals(localName) && isMusee) {
            currentMusee.setNom(st);
        }
        st = null;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isMusee) {
            st = new String(ch, start, length);
        }
    }
}
