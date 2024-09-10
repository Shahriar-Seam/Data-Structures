#include <stdio.h>
#include "linked_list.h"

int main()
{
    node *head = NULL, *head2 = NULL;

    printf("heh\n");
    insert(head, 50);


    append(&head, 20);

    prepend(&head, 5);
    prepend(&head, 2);
    prepend(&head, 3);

    append(&head, 10);

    insert(search(head, 10), 30);

    remove_node(&head, search(head, 20));
    remove_node(&head, search(head, 3));
    remove_node(&head, search(head, 2));
    remove_node(&head, search(head, 5));
    remove_node(&head, search(head, 30));
    remove_node(&head, search(head, 10));
    remove_node(&head, head);

    insert_sorted(&head, 5);
    insert_sorted(&head, 4);
    insert_sorted(&head, 9);
    insert_sorted(&head, 2);
    insert_sorted(&head, 3);
    insert_sorted(&head, 8);
    insert_sorted(&head, 6);
    insert_sorted(&head, 9);

    insert_sorted(&head2, 5);
    insert_sorted(&head2, 0);
    insert_sorted(&head2, -5);
    insert_sorted(&head2, -98);
    insert_sorted(&head2, 65);
    insert_sorted(&head2, 12);
    insert_sorted(&head2, -8);
    insert_sorted(&head2, 50);

    reverse(&head);

    sort(&head);

    // delete_list(&head);
    // delete_list(&head2);

    // merge(&head, &head2);

    head = sorted_merge(head, head2);

    fprintf(stderr, "%p %p\n", search(head, 3), head);

    printf("Total elements = %d\n", count_nodes(head));

    print_list(head);


    return 0;
}