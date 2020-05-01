import mill._
import mill.scalalib._

def source = T.source{
  PathRef(os.pwd / "file.txt")
}

def source2 = T.source{
  PathRef(os.pwd / "file2.txt")
}

def concated = T{
  println("CONCAT")
  Thread.sleep(500)
  println("CONCAT END")
  os.read(source().path) + os.read(source2().path)
}
def split1 = T{
  println("SPLIT 1")
  Thread.sleep(500)
  println("SPLIT 1 END")
  concated().take(concated().length / 2)
}
def split2 = T{
  println("SPLIT 2")
  Thread.sleep(1000)
  println("SPLIT 2 END")
  concated().drop(concated().length / 2)
}
def split3 = T{
  println("SPLIT 3")
  Thread.sleep(1500)
  println("SPLIT 3 END")
  concated().take(concated().length / 2)
}
def split4 = T{
  println("SPLIT 4")
  Thread.sleep(2000)
  println("SPLIT 4 END")
  concated().drop(concated().length / 2)
}
def join = T{
  println("JOIN 5")
  Thread.sleep(500)
  println("JOIN END")
  split2() + split1() + split4() + split3()
}