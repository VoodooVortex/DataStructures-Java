class node {
    Object data;
    node link;
    node plink;

    node(node pl, Object d, node l) {
        data = d;
        link = l;
        plink = pl;
    }
}