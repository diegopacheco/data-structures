import { LinkedList } from "./list.ts";

const list = new LinkedList<number>();
list.insertAtBegin(30);
list.insertAtBegin(20);
list.insertAtBegin(10);
list.insertAtEnd(40);
list.insertAtEnd(50);

console.log("List: ");
list.printList();

list.deleteNode(40);
console.log("List after deleting 40: ");
list.printList();

if (list.searchNode(4)) {
    console.log("4 is in the list");
} else {
    console.log("4 is not in the list");
}