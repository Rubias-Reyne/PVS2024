package III.streaming.test;

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookTask {
    static class Book{
        private int bookId;
        private String title;
        private String author;
        private List<Chapter> chapters = new ArrayList<>();

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getTotalPages() {
            // TODO: 26.03.2025 Dodelat, bude se hodit
            int count = 0;
            for (Chapter chapter:this.chapters){
                count += chapter.getPages();
            }
            return count;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public List<Chapter> getChapters() {
            return chapters;
        }

        @Override
        public String toString() {
            for(Chapter chapter:chapters){
                System.out.println(chapter.getTitle());
                System.out.println(chapter.getBookId());
            }
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", chapters=" + chapters +
                    '}';
        }
    }

    static class Chapter {
        // TODO: 26.03.2025 Dodelat vse potrebne
        private int chapterId;
        private int bookId;
        private String title;
        private int pages;

        public Chapter(int chapterId, int bookId, String title, int pages) {
            this.chapterId = chapterId;
            this.bookId = bookId;
            this.title = title;
            this.pages = pages;
        }

        public int getChapterId() {
            return chapterId;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public int getPages() {
            return pages;
        }
    }

    public static List<Chapter> readChapters(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Chapter> l = new ArrayList<>();
        String line;
        br.readLine();
        while ((line = br.readLine()) != null){
//            System.out.println(line);
            String[] params = line.split(",");
            Chapter c = new Chapter(
                    Integer.parseInt(params[0]),
                    Integer.parseInt(params[1]),
                    params[2],
                    Integer.parseInt(params[3]));
            l.add(c);
        }
        br.close();
        return l;
    }

    public static List<Book> readBooks(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Book> l = new ArrayList<>();
        String line;
        br.readLine();
        while ((line = br.readLine()) != null){
//            System.out.println(line);
            String[] params = line.split(",");
            Book b = new Book(
                    Integer.parseInt(params[0]),
                    params[1],
                    params[2]);
            l.add(b);
        }
        br.close();
        return l;
    }

    public static void main(String[] args) throws IOException {

        File chaptersFile = new File("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PVS2024\\src\\III\\streaming\\test\\chapters.csv");
        File booksFile = new File("C:\\Users\\vladimir.topolcany\\IdeaProjects\\PVS2024\\src\\III\\streaming\\test\\books.csv");
        List<Chapter> chapters = readChapters(chaptersFile);
        List<Book> books = readBooks(booksFile);


        for (Book book:books){
            for (Chapter chapter:chapters){
                if (book.getBookId() == chapter.getBookId()){
                    book.getChapters().add(chapter);
                }
            }
        }

//        HashMap<String, List<Chapter>> bookMap = books.stream()
        HashMap<String, List<Chapter>> bookMap = new HashMap<>();
        HashMap<String, Integer> authorMap = new HashMap<>();

        for (Book book  : books) {
            bookMap.put(book.getTitle(), book.getChapters());
        }

        for (Book book  : books) {
            if (authorMap.containsKey(book.getAuthor())){
                int count = 0;
                for (Book book1:books){
                    if (book1.getAuthor().equals(book.getAuthor())){
                        count++;
                    }
                }
                authorMap.put(book.getAuthor(), count);
                System.out.println(book.getAuthor() + " - " + count);
            }
            authorMap.put(book.getAuthor(), 0);
        }
        for (Book book: books){

            book.getTotalPages();
        }
    }

}
