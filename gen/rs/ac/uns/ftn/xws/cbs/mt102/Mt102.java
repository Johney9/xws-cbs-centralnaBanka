
package rs.ac.uns.ftn.xws.cbs.mt102;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_poruke" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TID"/>
 *         &lt;element name="swift_kod_banke_duznika" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TSWIFT"/>
 *         &lt;element name="obracunski_racun_banke_duznika" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TRacun"/>
 *         &lt;element name="swift_kod_banke_poverioca" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TSWIFT"/>
 *         &lt;element name="obracunski_racun_banke_poverioca" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TRacun"/>
 *         &lt;element name="ukupan_iznos" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TIznos"/>
 *         &lt;element name="sifra_valute" type="{http://www.ftn.uns.ac.rs/xws/cbs/tipovi}TSifraValute"/>
 *         &lt;element name="datum_valute" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="pojedinacni_nalozi" type="{http://www.ftn.uns.ac.rs/xws/cbs/mt102}MT102PojedinacniNalog" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idPoruke",
    "swiftKodBankeDuznika",
    "obracunskiRacunBankeDuznika",
    "swiftKodBankePoverioca",
    "obracunskiRacunBankePoverioca",
    "ukupanIznos",
    "sifraValute",
    "datumValute",
    "datum",
    "pojedinacniNalozi"
})
@XmlRootElement(name = "mt102")
public class Mt102 {

    @XmlElement(name = "id_poruke", required = true)
    protected String idPoruke;
    @XmlElement(name = "swift_kod_banke_duznika", required = true)
    protected String swiftKodBankeDuznika;
    @XmlElement(name = "obracunski_racun_banke_duznika", required = true)
    protected String obracunskiRacunBankeDuznika;
    @XmlElement(name = "swift_kod_banke_poverioca", required = true)
    protected String swiftKodBankePoverioca;
    @XmlElement(name = "obracunski_racun_banke_poverioca", required = true)
    protected String obracunskiRacunBankePoverioca;
    @XmlElement(name = "ukupan_iznos", required = true)
    protected BigDecimal ukupanIznos;
    @XmlElement(name = "sifra_valute", required = true)
    protected String sifraValute;
    @XmlElement(name = "datum_valute", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumValute;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "pojedinacni_nalozi", required = true)
    protected List<MT102PojedinacniNalog> pojedinacniNalozi;

    /**
     * Gets the value of the idPoruke property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPoruke() {
        return idPoruke;
    }

    /**
     * Sets the value of the idPoruke property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPoruke(String value) {
        this.idPoruke = value;
    }

    /**
     * Gets the value of the swiftKodBankeDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwiftKodBankeDuznika() {
        return swiftKodBankeDuznika;
    }

    /**
     * Sets the value of the swiftKodBankeDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwiftKodBankeDuznika(String value) {
        this.swiftKodBankeDuznika = value;
    }

    /**
     * Gets the value of the obracunskiRacunBankeDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObracunskiRacunBankeDuznika() {
        return obracunskiRacunBankeDuznika;
    }

    /**
     * Sets the value of the obracunskiRacunBankeDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObracunskiRacunBankeDuznika(String value) {
        this.obracunskiRacunBankeDuznika = value;
    }

    /**
     * Gets the value of the swiftKodBankePoverioca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwiftKodBankePoverioca() {
        return swiftKodBankePoverioca;
    }

    /**
     * Sets the value of the swiftKodBankePoverioca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwiftKodBankePoverioca(String value) {
        this.swiftKodBankePoverioca = value;
    }

    /**
     * Gets the value of the obracunskiRacunBankePoverioca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObracunskiRacunBankePoverioca() {
        return obracunskiRacunBankePoverioca;
    }

    /**
     * Sets the value of the obracunskiRacunBankePoverioca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObracunskiRacunBankePoverioca(String value) {
        this.obracunskiRacunBankePoverioca = value;
    }

    /**
     * Gets the value of the ukupanIznos property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUkupanIznos() {
        return ukupanIznos;
    }

    /**
     * Sets the value of the ukupanIznos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUkupanIznos(BigDecimal value) {
        this.ukupanIznos = value;
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

    /**
     * Gets the value of the datumValute property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumValute(XMLGregorianCalendar value) {
        this.datumValute = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the pojedinacniNalozi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pojedinacniNalozi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPojedinacniNalozi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MT102PojedinacniNalog }
     * 
     * 
     */
    public List<MT102PojedinacniNalog> getPojedinacniNalozi() {
        if (pojedinacniNalozi == null) {
            pojedinacniNalozi = new ArrayList<MT102PojedinacniNalog>();
        }
        return this.pojedinacniNalozi;
    }

}
