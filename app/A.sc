def sumOp = (a:Int, b:Int) => a + b
def productOp = (a:Int, b:Int) => a * b

def recursiveSum(ls:List[Int]):Int = {
  recursiveCompute(ls, 0, sumOp)
}

def recursiveProduct(ls:List[Int]):Int = {
  recursiveCompute(ls, 1, productOp)
}

def recursiveCompute(ls: List[Int], neutral: Int, func: (Int, Int) => Int): Int = {
  if (ls.isEmpty)
    neutral
  else
    func(ls.head, recursiveCompute(ls.tail, neutral, func))
}


def tailRecursiveCompute(ls: List[Int], acc: Int = 0, func: (Int, Int) => Int): Int = {
  if (ls.isEmpty)
    acc
  else
    tailRecursiveCompute(ls.tail, func(acc, ls.head), func)
}

def sum(ls: List[Int]): Int = {
  tailRecursiveCompute(ls, 0, sumOp)
}

def product(ls: List[Int]): Int = {
  tailRecursiveCompute(ls, 1, productOp)
}

val list = List(5, 1, 2, 3, 4)
recursiveSum(list)
sum(list)

recursiveProduct(list)
product(list)

