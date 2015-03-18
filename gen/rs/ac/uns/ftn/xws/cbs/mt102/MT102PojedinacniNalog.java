
package rs.ac.uns.ftn.xws.cbs.mt102;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MT102PojedinacniNalog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MT102PojedinacniNalog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_naloga_za_placanje" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TID"/>
 *         &lt;element name="duznik_nalogodavac" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TNaziv"/>
 *         &lt;element name="svrha_placanja" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TNaziv"/>
 *         &lt;element name="primalac_poverilac" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TNaziv"/>
 *         &lt;element name="datum_naloga" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="racun_duznika" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TRacun"/>
 *         &lt;element name="model_zaduzenja" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TModel"/>
 *         &lt;element name="poziv_na_broj_zaduzenja" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TPozivNaBroj"/>
 *         &lt;element name="racun_poverioca" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TRacun"/>
 *         &lt;element name="model_odobrenja" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TModel"/>
 *         &lt;element name="poziv_na_broj_odobrenja" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TPozivNaBroj"/>
 *         &lt;element name="iznos" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TIznos"/>
 *         &lt;element name="sifra_valute" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TSifraValute"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MT102PojedinacniNalog", propOrder = {
    "idNalogaZaPlacanje",
    "duznikNalogodavac",
    "svrhaPlacanja",
    "primalacPoverilac",
    "datumNaloga",
    "racunDuznika",
    "modelZaduzenja",
    "pozivNaBrojZaduzenja",
    "racunPoverioca",
    "modelOdobrenja",
    "pozivNaBrojOdobrenja",
    "iznos",
    "sifraValute"
})
public class MT102PojedinacniNalog {

    @XmlElement(name = "id_naloga_za_placanje", required = true)
    protected String idNalogaZaPlacanje;
    @XmlElement(name = "duznik_nalogodavac", required = true)
    protected String duznikNalogodavac;
    @XmlElement(name = "svrha_placanja", required = true)
    protected String svrhaPlacanja;
    @XmlElement(name = "primalac_poverilac", required = true)
    protected String primalacPoverilac;
    @XmlElement(name = "datum_naloga", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumNaloga;
    @XmlElement(name = "racun_duznika", required = true)
    protected String racunDuznika;
    @XmlElement(name = "model_zaduzenja", required = true)
    protected String modelZaduzenja;
    @XmlElement(name = "poziv_na_broj_zaduzenja", required = true)
    protected String pozivNaBrojZaduzenja;
    @XmlElement(name = "racun_poverioca", required = true)
    protected String racunPoverioca;
    @XmlElement(name = "model_odobrenja", required = true)
    protected String modelOdobrenja;
    @XmlElement(name = "poziv_na_broj_odobrenja", required = true)
    protected String pozivNaBrojOdobrenja;
    @XmlElement(required = true)
    protected BigDecimal iznos;
    @XmlElement(name = "sifra_valute", required = true)
    protected String sifraValute;

    /**
     * Gets the value of the idNalogaZaPlacanje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNalogaZaPlacanje() {
        return idNalogaZaPlacanje;
    }

    /**
     * Sets the value of the idNalogaZaPlacanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNalogaZaPlacanje(String value) {
        this.idNalogaZaPlacanje = value;
    }

    /**
     * Gets the value of the duznikNalogodavac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuznikNalogodavac() {
        return duznikNalogodavac;
    }

    /**
     * Sets the value of the duznikNalogodavac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuznikNalogodavac(String value) {
        this.duznikNalogodavac = value;
    }

    /**
     * Gets the value of the svrhaPlacanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    /**
     * Sets the value of the svrhaPlacanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrhaPlacanja(String value) {
        this.svrhaPlacanja = value;
    }

    /**
     * Gets the value of the primalacPoverilac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimalacPoverilac() {
        return primalacPoverilac;
    }

    /**
     * Sets the value of the primalacPoverilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimalacPoverilac(String value) {
        this.primalacPoverilac = value;
    }

    /**
     * Gets the value of the datumNaloga property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumNaloga() {
        return datumNaloga;
    }

    /**
     * Sets the value of the datumNaloga property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumNaloga(XMLGregorianCalendar value) {
        this.datumNaloga = value;
    }

    /**
     * Gets the value of the racunDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacunDuznika() {
        return racunDuznika;
    }

    /**
     * Sets the value of the racunDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacunDuznika(String value) {
        this.racunDuznika = value;
    }

    /**
     * Gets the value of the modelZaduzenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelZaduzenja() {
        return modelZaduzenja;
    }

    /**
     * Sets the value of the modelZaduzenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelZaduzenja(String value) {
        this.modelZaduzenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojZaduzenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojZaduzenja() {
        return pozivNaBrojZaduzenja;
    }

    /**
     * Sets the value of the pozivNaBrojZaduzenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojZaduzenja(String value) {
        this.pozivNaBrojZaduzenja = value;
    }

    /**
     * Gets the value of the racunPoverioca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacunPoverioca() {
        return racunPoverioca;
    }

    /**
     * Sets the value of the racunPoverioca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacunPoverioca(String value) {
        this.racunPoverioca = value;
    }

    /**
     * Gets the value of the modelOdobrenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelOdobrenja() {
        return modelOdobrenja;
    }

    /**
     * Sets the value of the modelOdobrenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelOdobrenja(String value) {
        this.modelOdobrenja = value;
    }

    /**
     * Gets the value of the pozivNaBrojOdobrenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPozivNaBrojOdobrenja() {
        return pozivNaBrojOdobrenja;
    }

    /**
     * Sets the value of the pozivNaBrojOdobrenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPozivNaBrojOdobrenja(String value) {
        this.pozivNaBrojOdobrenja = value;
    }

    /**
     * Gets the value of the iznos property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIznos() {
        return iznos;
    }

    /**
     * Sets the value of the iznos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIznos(BigDecimal value) {
        this.iznos = value;
    }

    /**
     * Gets the value of the sifraValute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraValute() {
        return sifraValute;
    }

    /**
     * Sets the value of the sifraValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraValute(String value) {
        this.sifraValute = value;
    }

}
