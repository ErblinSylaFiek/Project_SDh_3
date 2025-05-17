<div align="center" id="top">
  <img src="upLogo.png" width ="150"  alt="upLogo"/>
</div>

<h1 align="center">Komunikim i Sigurt TCP Klient-Server me DES-CBC dhe RSA</h1>

---

## 📄 Përshkrimi

Ky projekt demonstron një implementim praktik të sigurisë në komunikim duke përdorur algoritmin **DES në mënyrën CBC** për enkriptimin e mesazhit dhe **RSA për enkriptimin e çelësit sekret**. Komunikimi ndodh përmes një lidhjeje **TCP midis klientit dhe serverit**.

---

## 📂 Struktura e Projektit

- **/src/**: përmban skedarët kryesorë të aplikacionit:
    - `Client.java` – Enkripton mesazhin dhe e dërgon te serveri
    - `Server.java` – Pranon dhe dekripton mesazhin
    - `KeyManager.java` – Gjeneron dhe menaxhon çelësat RSA dhe DES
    - `Main.java` – Nis si serverin ashtu edhe klientin për testim

---

## ⚙️ Funksionalitetet

🔐 **Gjenerimi i çelësave RSA (2048-bit)**  
🧬 **Gjenerimi i çelësit sekret DES (8 byte)**  
🔒 **Enkriptimi i mesazhit me DES/CBC/PKCS5Padding**  
🔑 **Enkriptimi i çelësit sekret me RSA**  
📤 **Dërgimi i mesazhit dhe çelësit të enkriptuar përmes TCP Socket**  
📥 **Dekriptimi i çelësit me RSA dhe më pas i mesazhit me DES në server**  
🧪 **Testim automatik përmes klasës `Main`**

---

## 🛠️ Përmbajtja e Klasave

### `Main.java`
Nis të dy komponentët (serverin dhe klientin) në mënyrë automatike me një vonesë të shkurtër për të simuluar komunikimin.

### `Client.java`
- Gjeneron çelësin sekret DES.
- Enkripton mesazhin me DES dhe çelësin me RSA.
- Dërgon të dhënat nëpërmjet një socket-i te serveri.

### `Server.java`
- Pret lidhje nga klienti.
- Merr çelësin e enkriptuar, mesazhin dhe IV.
- Dekriptohet çelësi me çelësin privat RSA dhe më pas mesazhi me DES.

### `KeyManager.java`
- Gjeneron dhe ruan çelësat RSA në skedarë (`server_private.key`, `server_public.key`).
- Gjeneron çelësin sekret DES.
- Konverton byte në format hex për vizualizim.

---

## Instalimi

### 1. Klononi:
```bash
git clone https://github.com/ErblinSylaFiek/Project_SDh_3
```

## Licensa

Ky projekt është i licensuar nën [MIT License](LICENSE).


## Punuan
- Erblin Syla
- Erëza Greiçevci
- Era Berisha
- Erik Behrami

<br>

<a href="#top" style="text-decoration: underline">Shko në fillim ↑</a>


