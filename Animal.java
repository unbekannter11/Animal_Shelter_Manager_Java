import java.util.Date;


     // a
public abstract class Animal {


         /**
          * Dieses Feld speichert den aktuellen Status des Tieres.
          * Der Status kann verschiedene Zustände des Tieres repräsentieren,
          * wie z.B. neu angekommen, in Quarantäne, reserviert oder adoptiert.
          */
    private int status;

         /**
          * Dieses Feld speichert den Namen des Tieres.
          * Der Name ist eindeutig für jedes Tier und wird bei der Erstellung des Tierobjekts festgelegt.
          */

    private final String name;

         /**
          * Dieses Feld speichert das Geburtsdatum des Tieres.
          * Das Geburtsdatum wird verwendet, um das Alter des Tieres zu berechnen.
          */
    private final Date dateOfBirth;

         /**
          * Dieses Feld gibt den Hunger des Tieres an.
          * Der Hunger ist ein Wert, der angibt, wie hungrig das Tier ist.
          * Ein höherer Wert bedeutet, dass das Tier hungriger ist.
          * Der Hunger kann durch Füttern des Tieres verringert werden.
          */
    protected int hunger;


         /**
          * Konstruktor, um ein neues Tier mit einem Namen und einem Geburtsdatum zu erstellen.
          *
          * Erstellung nur im Falle einer Vererbung möglich
          * Dieser Konstruktor initialisiert ein Tierobjekt mit den übergebenen Werten.
          * Der Status des Tieres wird auf 0 gesetzt (was normalerweise "New Arrival" bedeutet),
          * und der Hunger wird auf 100 gesetzt, was den höchsten Hungerzustand repräsentiert.
          *
          * @param name Der Name des Tieres.
          * @param dateOfBirth Das Geburtsdatum des Tieres.
          */


    protected  Animal(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.status = 0;
        this.hunger = 100;
    }

    //c
    /*  c) Recherchefrage: Schauen Sie sich im Internet die Dokumentation der Klasse java.util.Date an
und finden Sie zusätzlich heraus, wie Sie die aktuelle Systemzeit in Millisekunden bekommen
können.

public static long currentTimeMillis()
Returns the current time in milliseconds. Note that while the unit of time of the return value
is a millisecond, the granularity of the value depends on the underlying operating system and may
be larger. For example, many operating systems measure time in units of tens of milliseconds.
See the description of the class Date for a discussion of slight discrepancies that may arise
between "computer time" and coordinated universal time (UTC).

Returns:
the difference, measured in milliseconds, between the current time and midnight, January 1, 1970 UTC.
See Also:
Date

System.out.println(System.currentTimeMillis());
*/

    //d
    /*
   d) Recherchefrage: Wie könnte man die möglichen Status besser implementieren?
Enums
An enum is a special "class" that represents a group of constants (unchangeable variables,
like final variables).

To create an enum, use the enum keyword (instead of class or interface), and separate the constants
with a comma. Note that they should be in uppercase letter.

Difference between Enums and Classes
An enum can, just like a class, have attributes and methods. The only difference is that enum constants
are public, static and final (unchangeable - cannot be overridden).

An enum cannot be used to create objects, and it cannot extend other classes (but it can implement
interfaces).

Why And When To Use Enums?
Use enums when you have values that you know aren't going to change, like month days, days, colors,
deck of caards, etc.

     public enum moeglicheStatus{
        NEW_ARRAIVAL;
        QUARANTINE;
        RESERVED;
        ADOPTED
    }


 */


    //
    /**
     * e) long getAge(),die das aktuelle Alter des Tieres in Jahren zurückgibt
     * Berechnet das aktuelle Alter des Tieres in Jahren.
     * Diese Methode berechnet die Differenz zwischen dem aktuellen Datum und dem Geburtsdatum des Tieres,
     * um das Alter in Jahren zu ermitteln. Beachten Sie, dass diese Berechnung auf der Annahme basiert,
     * dass ein Jahr 365 Tage hat. Diese Vereinfachung kann zu geringfügigen Ungenauigkeiten führen,
     * insbesondere bei Schaltjahren.
     *
     * @return Das Alter des Tieres in Jahren als long-Wert.
     */
    public long getAge(){
        long birthOfDateMillis = dateOfBirth.getTime();
        long currentTime = System.currentTimeMillis();
        long ageMilles = currentTime - birthOfDateMillis;
        long ageYears = ageMilles /(1000 * 60 * 60* 24* 365L);
        return ageYears;
    }


         /**
          * Gibt den aktuellen Hungerwert des Tieres zurück.
          *
          * Der Hungerwert ist ein Maß für den Hungerzustand des Tieres. Ein höherer Wert bedeutet,
          * dass das Tier hungriger ist. Dieser Wert kann durch die Methode {@code feed(Meat meat)}
          * verringert werden, um das Tier zu füttern.
          *
          * @return Der aktuelle Hungerwert des Tieres.
          */
         public int getHunger() {
             return hunger;
         }

         /**
          * Setzt den Hungerwert des Tieres auf einen neuen Wert.
          *
          * Diese Methode ermöglicht es, den Hungerzustand des Tieres zu aktualisieren.
          * Ein niedrigerer Wert bedeutet, dass das Tier weniger hungrig ist.
          * Dies kann nützlich sein, um den Effekt der Fütterung oder anderer Ereignisse
          * auf den Hungerzustand des Tieres zu simulieren.
          *
          * @param hunger Der neue Hungerwert für das Tier. Sollte nicht negativ sein.
          */
         public void setHunger(int hunger) {
             this.hunger = hunger;
         }


         // f) String getReadableStatus(), die den Status des Tieres in einen lesbaren String übersetzt.
         /**
          * Setzt den Status des Tieres auf einen neuen Wert.
          *
          * Der Status gibt den aktuellen Zustand des Tieres an, wie z.B. neu angekommen, in Quarantäne,
          * reserviert oder adoptiert. Die möglichen Statuswerte werden in der {@code AdoptingManagement}
          * Klasse definiert.
          *
          * @param status Der neue Statuswert für das Tier.
          */
    public void setStatus(int status) {

        this.status = status;
    }

         /**
          * Gibt den aktuellen Status des Tieres als lesbaren String zurück.
          *
          * Diese Methode übersetzt den numerischen Statuswert des Tieres in einen lesbaren String,
          * basierend auf den in der {@code AdoptingManagement} Klasse definierten möglichen Statuswerten.
          * Falls der Statuswert außerhalb des gültigen Bereichs liegt, wird "unknown" zurückgegeben.
          *
          * @return Der lesbare Status des Tieres als String.
          */
    public String getReadableStatus(){

        if (status >= 0 && status < AdoptingManagement.moeglicheStatus.length) {
            return AdoptingManagement.moeglicheStatus[status];
        } else {
            return "unkwown";
        }
    }


    // g) String getName(), die den Namen des Tieres zurückgibt

         /**
          * Gibt den Namen des Tieres zurück.
          *
          * Der Name ist bei der Erstellung des Tierobjekts festgelegt und identifiziert das Tier eindeutig.
          * Diese Methode ermöglicht den Zugriff auf den Namen des Tiere.
          *
          * @return Der Name des Tieres als String.
          */
    public String getName(){

        return name;
    }

    // h)  boolean updateStatus(int status), die den Status des Tieres auf einen neuen aktualisiert.Prüfen Sie,
    //ob der neue Status innerhalb des Bereichs der möglichen, bereits angelegten Status
    //liegt und setzen Sie den neuen Status nur, wenn der Check positiv verläuft. Geben Sie true zurück,
    //wenn es sich um einen gültigen Status handelt und false andernfalls.

         /**
          * Aktualisiert den Status des Tieres auf einen neuen Wert.
          *
          * Diese Methode überprüft zunächst, ob der neue Statuswert innerhalb des gültigen Bereichs der
          * in {@code AdoptingManagement} definierten möglichen Status liegt. Ist der neue Status gültig,
          * wird der Status des Tieres aktualisiert, und die Methode gibt {@code true} zurück.
          * Andernfalls bleibt der Status unverändert, und die Methode gibt {@code false} zurück.
          *
          *
          * @param newStatus Der neue Statuswert für das Tier.
          * @return {@code true}, wenn der neue Status gültig ist und erfolgreich aktualisiert wurde,
          *         {@code false}, wenn der neue Status außerhalb des gültigen Bereichs liegt.
          */
    public boolean updateStatus(int newStatus){

        if(newStatus >= 0 && newStatus < AdoptingManagement.moeglicheStatus.length){
            this.status= newStatus;
            return true;
        }else{
            return false;
        }
    }

    // i) int getStatus(), die den gesetzten Status des Tieres zurückgibt.

         /**
          * Gibt den aktuellen Status des Tieres zurück.
          *
          *
          * Der Status ist eine ganze Zahl, die den Zustand des Tieres in der Tierverwaltung
          * repräsentiert. Die Bedeutung der Statuswerte ist in der Klasse {@code AdoptingManagement}
          * definiert, wo sie als Konstanten hinterlegt sind.
          *
          * @return Der aktuelle Status des Tieres als int-Wert.
          */
     public int getStatus(){
        return status;
         }

     // j) String makeSound(), eine abstrakte Methode, die das Geräusch, das das Tier macht, zurückgeben soll.
         /**
          * Gibt das Geräusch zurück, das das Tier macht.
          * Diese Methode ist abstrakt und muss in den abgeleiteten Klassen implementiert werden.
          * Jedes Tier macht ein charakteristisches Geräusch, und die Implementierung dieser Methode
          * in den Unterklassen sollte dieses Geräusch in Form eines Strings zurückgeben.
          *
          * @return Das Geräusch des Tieres als String.
          */
     public abstract String makeSound();

}


      /* b) Erstellen Sie nun eine Klasse AdoptingManagement. Die Klasse soll ein Feld vom Typ Animal[].
besitzen, in welchem die Tiere gespeichert werden sollen. Außerdem soll die Klasse eine Konstante
aufweisen, die alle möglichen Status speichert. Die Konstante soll vom Typen String[] sein und
von der Instanz der Klasse losgelöst sein. In diesem Feld sollen die Werte
"New Arrival","Quarantine","Reserved","Adopted" einmalig gesetzt werden.
      */

/**
 * Die Klasse AdoptingManagement verwaltet die Tieraufnahme und Adoptionsprozesse.
 * Sie speichert Tiere in einem Array und verfolgt deren Status in der Einrichtung.
 */
class AdoptingManagement{


    /**
     * in diesem Feld werden die Tiere gespeichert
     */
    private Animal [] animals;


    /**
     * Ealle mögliche Status
     * diese Statuswerte umfassen "New Arrival", "Quarantine", "Reserved", und "Adopted".
     */
    public static final String [] moeglicheStatus = {"New Arrival","Quarantine","Reserved","Adopted"};

    // aus l
    /**
     * Die Kapazität der Einrichtung, also wie viele Tiere maximal aufgenommen werden können.
     */
    private int capacity;

    /**
     * Der Konstruktor für AdoptingManagement. Setzt die start Kapazität for die Aufnahme von Tieren
     * und initialisiert das Array von Tieren mit dieser Kapazität.
     *
     * @param initialCapacity Die start Kapazität der Einrichtung.
     */

    public AdoptingManagement(int initialCapacity) {
        this.capacity = initialCapacity;
        this.animals = new Animal[capacity];
    }


    /*
    k) String getAnimalNames(), eine rekursive Methode, die die Namen aller aktuellen Tiere der Reihenfolge
    nach und mit einem Komma getrennt zurückliefert.
    Hinweis: Verwenden Sie private Hilfsmethoden in Ihrer Implementierung.
    */


    /**
     * Gibt die Namen aller Tiere in der Einrichtung, getrennt durch Kommas, in der Reihenfolge zurück.
     *
     * @return Eine durch Kommas getrennte Zeichenkette mit den Namen aller Tiere.
     *         Gibt einen leeren String zurück, wenn keine Tiere vorhanden sind.
     */

    public String getAnimalNames(){
        if(animals == null || animals.length == 0){
            return "";
        }
        return getAnimalNamesHelping(0);
    }

    /**
     * Eine private Hilfsmethode zur Unterstützung der Rekursion für {@code getAnimalNames}.
     * Ruft sich selbst rekursiv auf, um den nächsten Namen in der Liste zu erhalten, bis alle Namen abgerufen sind.
     *
     * @param start Der Startindex für den rekursiven Durchlauf durch das Array der Tiere.
     * @return Eine Teilzeichenkette der Namen, beginnend beim Index {@code start}, gefolgt von einem Komma,
     *         wenn weitere Namen folgen.
     */

    private String getAnimalNamesHelping(int start){
        if(start >= animals.length){
            return "";
        }

        String toComma = (start == animals.length-1) ? "" : ", ";
        return animals[start].getName() + toComma + getAnimalNamesHelping(start + 1);
    }

    /*
    l ) boolean increaseCapacity(int newCapacity), die die Höhe der Kapazitäten der
Einrichtung erhöht. Geben Sie true zurück, sofern es sich bei der neuen Kapazität um eine
Steigerung handelt, ansonsten geben Sie false zurück. Denken Sie daran, nur bei einer positiven
Überprüfung die Kapazitäten zu verändern.

     */

    /**
     * Erhöht die Kapazität der Einrichtung, um mehr Tiere aufnehmen zu können.
     *
     * Wenn der übergebene Wert {@code newCapacity} größer als die aktuelle Kapazität ist,
     * wird das Array, das die Tiere speichert, auf die neue Kapazität erweitert. Bereits gespeicherte
     * Tiere bleiben erhalten. Die Methode gibt {@code true} zurück, wenn die Kapazität erfolgreich erhöht wurde.
     * Andernfalls, wenn der übergebene Wert nicht größer als die aktuelle Kapazität ist,
     * bleibt die Kapazität unverändert und die Methode gibt {@code false} zurück.
     *
     * @param newCapacity Die neue Kapazität der Einrichtung, zu der erweitert werden soll.
     * @return {@code true}, wenn die Kapazität erfolgreich erhöht wurde;
     *         {@code false}, wenn der übergebene Wert nicht größer als die aktuelle Kapazität ist.
     */
    public boolean increaseCapacity(int newCapacity) {
        if (newCapacity > capacity) {
            Animal[] newAnimals = new Animal[newCapacity];
            for (int i = 0; i < capacity; i++) {
                newAnimals[i] = animals[i];
            }
            animals = newAnimals;
            capacity = newCapacity;
            return true;
        }
        return false;
    }

     /*
     m) int getAnimalID(String name), eine Methode, die die ID (Position des Tieres innerhalb des 2
Arrays) eines Tieres mit dem Namen name zurückliefert. Sollte ein Tier nicht gefunden werden,
geben Sie -1 zurück. Sollten mehrere Tiere mit demselben Namen existieren, geben Sie -2 zurück.


      */


    /**
     * Ermittelt die ID (den Index) eines Tieres anhand seines Namens innerhalb des Arrays.
     *
     * Diese Methode durchläuft das Array der Tiere und vergleicht den Namen jedes Tieres mit dem gesuchten Namen.
     * Wenn ein Tier mit dem angegebenen Namen gefunden wird, gibt die Methode den Index dieses Tieres im Array zurück.
     * Wenn kein Tier gefunden wird, gibt die Methode -1 zurück.
     * Falls mehrere Tiere mit demselben Namen existieren, wird -2 zurückgegeben, um Mehrdeutigkeit anzuzeigen.
     *
     * @param name Der Name des Tieres, dessen ID gesucht wird.
     * @return Der Index des Tieres im Array, wenn genau ein Tier gefunden wird;
     *         -2, wenn mehrere Tiere mit demselben Namen gefunden werden;
     *         -1, wenn kein Tier mit dem Namen gefunden wird.
     */
     public int getAnimalID(String name) {
         int foundIndex = -1;
         for (int i = 0; i < animals.length; i++) {
             if (animals[i] != null && animals[i].getName().equals(name)) {
                 if (foundIndex != -1) {
                     // Wenn mehrere Übereinstimmungen gefunden werden, gib -2 zurück
                     return -2;
                 }
                 foundIndex = i;// speichern Index, die erst mal gefunden wurde
             }
         }
         return foundIndex; // keine Übereinstimmung, dann -1
     }

     /*
     n) boolean newArrival(Animal animal), die ein neues Tier im Tierheim aufnimmt. Geben Sie 3
true zurück, sofern ein Platz gefunden wurde und false, sofern kein Platz verfügbar ist.
Implementieren Sie für diesen Zweck die private Methode int findEmptySpot(), die eine freie
Stelle (null) in der Kapazität findet und zurückliefert. Sollte keine freie Stelle gefunden werden,
geben Sie -1 zurück.
      */

          // Aufnehmen - Tier


    /**
     * Nimmt ein neues Tier in das Tierheim auf, wenn ein Platz verfügbar ist.
     *
     * Diese Methode verwendet {@code findEmptySpot} um zu prüfen, ob im Tierheim ein freier Platz verfügbar ist.
     * Wenn ein Platz gefunden wird, wird das Tier an dieser Stelle im Array platziert und die Methode gibt {@code true} zurück.
     * Ist kein Platz verfügbar, wird das Tier nicht aufgenommen und die Methode gibt {@code false} zurück.
     *
     * @param animal Das aufzunehmende Tier.
     * @return {@code true}, wenn das Tier erfolgreich aufgenommen wurde,
     *         {@code false}, wenn kein Platz verfügbar ist.
     */
    public boolean newArrival(Animal animal){
        int emptySpotIndex = findEmptySpot();
        if (emptySpotIndex != -1){
            // setze Tier auf das gefundenen Platz
            animals[emptySpotIndex] = animal;
            return true;
        }
        return false; // wenn es keine Plazt gibt
    }



    /**
     * Sucht nach einer freien Stelle im Tierheim.
     *
     * Diese Methode durchläuft das Array von Tieren und sucht nach einem {@code null} Wert,
     * was bedeutet, dass dieser Platz im Array nicht belegt ist. Wenn ein freier Platz gefunden wird,
     * gibt die Methode den Index dieses Platzes zurück. Wird kein freier Platz gefunden, gibt die Methode -1 zurück.
     *
     * @return Der Index des ersten freien Platzes im Array oder -1, wenn kein Platz verfügbar ist.
     */

    private int findEmptySpot() {
        for(int i = 0; i < capacity; i++){
            if(animals[i] == null){
                return i;//d.h freier Platz gefunden
            }
        }

        return -1;// d.h keinen freie Platz gefunden
          }


    /*
        o) Animal adoptAnimal(int id), mit der ein Tier an der Position id adoptiert werden kann.
    Überprüfen Sie, ob ein Tier an der Position vorhanden ist und setzen Sie gegebenenfalls dann den
    Status des Tieres auf "Adpoted", sofern sich das Tier nicht aktuell in Quarantäne befindet.

     */


    /**
     * Adoptiert ein Tier anhand seiner ID, wenn es nicht in Quarantäne ist.
     *
     * Diese Methode überprüft, ob das Tier mit der gegebenen ID im Array vorhanden ist und nicht in Quarantäne steht.
     * Ist das Tier verfügbar und nicht in Quarantäne, wird sein Status auf "Adoptiert" gesetzt und das Tier wird zurückgegeben.
     * Ist das Tier in Quarantäne oder existiert nicht unter der angegebenen ID, wird {@code null} zurückgegeben.
     *
     * @param id Die ID des zu adoptierenden Tieres, entsprechend seiner Position im Array.
     * @return Das adoptierte Tier, wenn die Operation erfolgreich ist;
     *         {@code null}, wenn das Tier nicht existiert, bereits adoptiert wurde oder sich in Quarantäne befindet.
     */

          public Animal adoptAnimal(int id) {
              //  Quarantäne Status
              final int QUARANTINE = 1;
              //AdoptiertenStatus
              final int ADOPTED = 3;

              // Überprüfen, ob die ID gültig ist und ob ein Tier an dieser ID vorhanden ist
              if (id >= 0 && id < animals.length && animals[id] != null) {
                  // Überprüfen, ob das Tier nicht in Quarantäne ist
                  if (animals[id].getStatus() != QUARANTINE) {
                      animals[id].setStatus(ADOPTED); // Status auf Adoptiert setzen
                      return animals[id]; // Das adoptierte Tier zurückgeben
                  }
              }
              return null; //keine Tier vorhanden or in Quarantäne ist
          }

      }


/*

p) Erstellen Sie eine Klasse Meat, die eine Konstante int amount erhält, die für jede Instanz im
Konstruktor gesetzt werden kann. Erstellen Sie ebenfalls diesen Konstruktor.
 */
class Meat {
    // Konstante für die Menge des Fleisches.
    private final int amount;

    // Konstruktor, der die Menge des Fleisches setzt.
    public Meat(int amount) {
        this.amount = amount;
    }

    // Methode, um die Menge des Fleisches zu bekommen.
    public int getAmount() {
        return amount;
    }
}

/* q) Erstellen Sie das Interface Carnivore, welches eine zu implementierende Methode
void feed(Meat meat) enthält. */
interface Carnivore {
    // Methode, um das Fleisch zu füttern. Jedes fleischfressende Tier muss diese Methode implementieren.
    void feed(Meat meat);
}

 /*

 r) Erstellen Sie nun eine Klasse Cat, die sowohl von Animal erbt, als auch das Interface Carnivore
 implementiert. Implementieren Sie alle zu implementierenden Methoden sinnvoll.

 */

class Cat extends Animal implements Carnivore {

    public Cat(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    // Implementierung der Methode feed aus dem Interface Carnivore
    @Override
    public void feed(Meat meat) {
        System.out.println("Die Katze " + getName() + " frisst Fleisch mit " + meat.getAmount() + " Menge.");

        // Zum Beispiel könnte man hunger um den amount reduzieren:
        this.hunger = Math.max(0, this.hunger - meat.getAmount());
    }

    // Implementierung der abstrakten Methode makeSound aus der Klasse Animal
    @Override
    public String makeSound() {
        return "Miau"; // Geräusch, das die Katze macht
    }
}

/* s) Erstellen Sie nun ebenfalls die Klasse Fox, die sowohl von Animal erbt, als auch das Interface
Carnivore implementiert. Implementieren Sie alle zu implementierenden Methoden sinnvoll. */

class Fox extends Animal implements Carnivore {

    public Fox(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    // Implementierung der Methode feed aus dem Interface Carnivore
    @Override
    public void feed(Meat meat) {
        System.out.println("Der Fuchs " + getName() + " frisst Fleisch mit " + meat.getAmount() + " Menge.");

        this.hunger = Math.max(0, this.hunger - meat.getAmount());
    }


    @Override
    public String makeSound() {
        return "Hau hau";
    }
}




