mod list;
use list::LinkedList;

fn main() {
    let mut list = LinkedList::new();

    list.insert_at_begin(30);
    list.insert_at_begin(20);
    list.insert_at_begin(10);
    list.insert_at_end(40);
    list.insert_at_end(50);

    println!("List: ");
    list.print_list();

    list.delete_node(40);
    println!("List after deleting 40: ");
    list.print_list();

    if list.search_node(4) {
        println!("4 is in the list");
    } else {
        println!("4 is not in the list");
    }
}