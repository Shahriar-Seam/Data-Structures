#include <stdio.h>
#include <stdlib.h>

typedef struct node node;

struct node {
    int data;
    node *next;
};

node *create_node(int data, node *next);
void prepend(node **head, int data);
void append(node **head, int data);
void insert(node *node, int data);
void remove_node(node **head, node *n);
node *search(node *head, int data);
void insert_sorted(node **head, int data);
int count_nodes(node *head);
void reverse(node **head);
void sort(node **head);
void split_in_middle(node *head, node **left, node **right);
node *sorted_merge(node *left, node *right);
void merge(node **a, node **b);
void delete_list(node **head);
void print_list(node *head);

node *create_node(int data, node *next)
{
    node *new_node = (node *) malloc(sizeof(node));

    if (new_node == NULL) {
        fprintf(stderr, "Error! Could not create new node with data = %d.\n", data);

        exit(1);
    }

    new_node->data = data;
    new_node->next = next;

    return new_node;
}

void prepend(node **head, int data)
{
    *head = create_node(data, *head);
}

void append(node **head, int data)
{
    if (*head == NULL) {
        prepend(head, data);
    }
    else {
        node *current_node = *head;

        while (current_node->next != NULL) {
            current_node = current_node->next;
        }

        current_node->next = create_node(data, NULL);
    }
}

void insert(node *node, int data)
{
    if (node == NULL) {
        fprintf(stderr, "Could not insert %d in NULL.\n", data);
    }
    else {
        node->next = create_node(data, node->next);
    }
}

void remove_node(node **head, node *n)
{
    if (n == NULL) {
        fprintf(stderr, "Invalid node pointer (NULL) provided. None removed.\n");

        return;
    }

    if (n == *head) {
        *head = n->next;

        free(n);

        return;
    }

    node *current_node = *head;

    while (current_node != NULL) {
        if (current_node->next == n) {
            break;
        }

        current_node = current_node->next;
    }

    if (current_node != NULL) {
        current_node->next = n->next;

        free(n);
    }
}

node *search(node *head, int data)
{
    node *current_node = head;

    while (current_node != NULL) {
        if (current_node->data == data) {
            return current_node;
        }
        else {
            current_node = current_node->next;
        }
    }

    return current_node;
}

void insert_sorted(node **head, int data)
{
    if (*head == NULL || (*head)->data > data) {
        prepend(head, data);

        return;
    }

    node *current_node = *head;

    while (current_node->next != NULL && current_node->next->data < data) {
        current_node = current_node->next;
    }

    insert(current_node, data);
}

int count_nodes(node *head)
{
    int count = 0;
    node *current_node = head;

    while (current_node != NULL) {
        count++;

        current_node = current_node->next;
    }

    return count;
}

void reverse(node **head)
{
    if (*head != NULL) {
        node *current_node = *head, *rhead = NULL;

        while (current_node != NULL) {
            rhead = create_node(current_node->data, rhead);

            current_node = current_node->next;
        }

        *head = rhead;
    }
}

void sort(node **head)
{
    node *current_node = *head, *left, *right;

    if ((current_node == NULL) || (current_node->next == NULL)) {
        return;
    }

    split_in_middle(current_node, &left, &right);

    sort(&left);
    sort(&right);

    *head = sorted_merge(left, right);
}

void split_in_middle(node *head, node **left, node **right)
{
    node *fast = head->next, *slow = head;

    while (fast != NULL) {
        fast = fast->next;

        if (fast != NULL) {
            slow = slow->next;

            fast = fast->next;
        }
    }

    *left = head;
    *right = slow->next;

    slow->next = NULL;
}

node *sorted_merge(node *left, node *right)
{
    node *sorted_head = NULL;

    if (left == NULL) {
        return right;
    }
    else if (right == NULL) {
        return left;
    }

    if (left->data <= right->data) {
        sorted_head = left;

        sorted_head->next = sorted_merge(left->next, right);
    }
    else {
        sorted_head = right;

        sorted_head->next = sorted_merge(left, right->next);
    }

    return sorted_head;
}

void merge(node **a, node **b)
{
    node *merged = *a, *node_b = *b;

    if (merged == NULL) {
        *a = *b;
    }
    else {
        while (merged->next != NULL) {
            merged = merged->next;
        }

        merged->next = *b;
    }
}

void delete_list(node **head)
{
    if (*head == NULL) {
        return;
    }
    else {
        delete_list(&(*head)->next);

        free(*head);

        *head = NULL;
    }
}

void print_list(node *head)
{
    int i;
    node *current_node = head;

    for (i = 1; current_node != NULL; i++, current_node = current_node->next) {
        printf("Data %d = %d\n", i, current_node->data);
    }
}