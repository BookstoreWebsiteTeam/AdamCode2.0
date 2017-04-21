
package shoppingcart;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Myles on 3/28/17.
 */
public class Book implements Serializable{

    private String isbn;
    private String bookName;
    private String[] author;
    private String semester;
    private String course;
    private int section;
    private String professor;
    private int crn;
    private String buyDemand;
    private int newQuantity;
    private int usedQuantity;
    private int rentalQuantity;
    private int ebookQuantity;
    private double newPrice;
    private double usedPrice;
    private double rentalPrice;
    private double ebookPrice;
    private String description;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getBuyDemand() {
        return buyDemand;
    }

    public void setBuyDemand(String buyDemand) {
        this.buyDemand = buyDemand;
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(int newQuantity) {
        this.newQuantity = newQuantity;
    }

    public int getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(int usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    public int getRentalQuantity() {
        return rentalQuantity;
    }

    public void setRentalQuantity(int rentalQuantity) {
        this.rentalQuantity = rentalQuantity;
    }

    public int getEbookQuantity() {
        return ebookQuantity;
    }

    public void setEbookQuantity(int ebookQuantity) {
        this.ebookQuantity = ebookQuantity;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getUsedPrice() {
        return usedPrice;
    }

    public void setUsedPrice(double usedPrice) {
        this.usedPrice = usedPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public double getEbookPrice() {
        return ebookPrice;
    }

    public void setEbookPrice(double ebookPrice) {
        this.ebookPrice = ebookPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return Book information string
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", bookName='" + bookName + '\'' +
                ", author=" + Arrays.toString(author) +
                ", semester='" + semester + '\'' +
                ", course='" + course + '\'' +
                ", section=" + section +
                ", professor='" + professor + '\'' +
                ", crn=" + crn +
                ", buyDemand='" + buyDemand + '\'' +
                ", newQuantity=" + newQuantity +
                ", usedQuantity=" + usedQuantity +
                ", rentalQuantity=" + rentalQuantity +
                ", ebookQuantity=" + ebookQuantity +
                ", newPrice=" + newPrice +
                ", usedPrice=" + usedPrice +
                ", rentalPrice=" + rentalPrice +
                ", ebookPrice=" + ebookPrice +
                ", description='" + description + '\'' +
                '}';
    }
}