import tutt.caesar.encryptedText

object cipher extends App {

  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "

  val enc = (character:Char, shift:Int, alphabet:String) => alphabet((alphabet.indexOf(character.toUpper) + shift)%alphabet.size)
  val dec = (character:Char, shift:Int, alphabet:String) => alphabet((alphabet.indexOf(character.toUpper) - shift + alphabet.size)%alphabet.size)

  val cipher = (algo:(Char, Int, String) => Char, message:String, shift:Int, alphabet:String) => message.map(algo(_, shift, alphabet))

  val key = scala.io.StdIn.readLine("How many shifts: ").toInt
  val text = scala.io.StdIn.readLine("Text to encrypt: ")

  val encText = cipher(enc, text, key, alphabet)
  val decText = cipher(dec, encText, key, alphabet)

  printf("Encrypted message: %s\n",encText)
  printf("Decrypted message: %s\n",decText)

}
