public class Main {
    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf(0);
        bookShelf.appendBook("가");
        bookShelf.appendBook("나");
        bookShelf.appendBook("다");
        bookShelf.appendBook("라");
        BookShelfIterator bookShelfIterator = new BookShelfIterator(0,bookShelf);
        while(bookShelfIterator.hasNext()){
            System.out.println(((Book)bookShelfIterator.next()).getName());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregate {
    Iterator iterator();
}

class BookShelf implements Aggregate {
    Book[] books = {};
    int last;

    public BookShelf(int last) {
        this.last = last;
    }

    Object getBookAt(int i) {
        return books[i];
    }

    void appendBook(String name) {
        books[last] = new Book(name);
        last++;
    }

    int getLength() {
        return books.length;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(0, new BookShelf( this.last));
    }
}
class BookShelfIterator implements Iterator{

    int index = 0;
    BookShelf bookShelf;

    public BookShelfIterator(int index, BookShelf bookShelf) {
        this.index = index;
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        return (index < bookShelf.getLength());
    }

    @Override
    public Object next() {
        Book book = ((Book)bookShelf.getBookAt(index));
        index ++;
        return book;
    }
}
class Book {
    String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}





