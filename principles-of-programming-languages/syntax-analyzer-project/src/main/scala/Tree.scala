import scala.collection.mutable.ArrayBuffer

/**
  * Project: Programming Assignment 1
  * Author: Michael Kerl
  * Version: 1.0
  */

/**
  * A Tree is a multidimensional struction which contains branches and leaves.
  *
  * @param label for tree/branch
  */
class Tree(var label: String) {

  private val branches: ArrayBuffer[Tree] = new ArrayBuffer[Tree]

  def add(branch: Tree): Unit = branches.addOne(branch)

  private def print(current: Tree, tabs: String): String = {
    var out = ""
    if (current == null)
      out
    else {
      out += tabs + current.label + "\n"
      for (branch <- current.branches)
        out += print(branch, tabs + "\t")
      out
    }
  }

  override def toString = print(this, "")
}

// example code
object Tree {
  def main(args: Array[String]): Unit = {
    val tree = new Tree("A")
    val ab1 = new Tree("ab1")
    val ab2 = new Tree("ab2")
    val ab3 = new Tree("ab3")
    val abc1 = new Tree("abc1")
    val abc2 = new Tree("abc2")
    tree.add(ab1)
    tree.add(ab2)
    tree.add(ab3)
    ab1.add(abc1)
    ab1.add(abc2)
    print(tree)
  }
}
