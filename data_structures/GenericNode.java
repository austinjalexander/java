public class GenericNode<E> {

  // INSTANCE VARIABLES
  private E content;
  private GenericNode next;

  // CONSTRUCTORS
  public GenericNode() {
    this.content = null;
    this.next = null;
  }
  public GenericNode(E content) {
    this.content = content;
    this.next = null;
  }
  public GenericNode(E content, GenericNode next) {
    this.content = content;
    this.next = next;
  }
}


    //GenericNode empty_node = new GenericNode();
    //GenericNode<Double> node = new GenericNode<>();
    //GenericNode<Double> node = new GenericNode<>(135.0);
    //GenericNode<String> node = new GenericNode<>();
    //GenericNode<String> node = new GenericNode<>("Sara");
