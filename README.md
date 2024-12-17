# Directory Lister 📁

## 📄 Description
This Java project lists the content of a directory in alphabetical order, starting from a given directory path. The program provides a concise and straightforward way to display the names of files and directories, working seamlessly with or without command-line arguments.

### **Functionality**
Core Features:
- Displays the names of files and directories within a specified directory in alphabetical order.
- Handles:
    - Input paths provided as command-line arguments.
    - Default behavior: creates and lists a directory named `TestFolder` in the project root if no arguments are provided.
- Validates the provided path to ensure it exists and is a directory.

Robust Design:
- Modular structure:
    - `Utils.java` handles validations and utility functions.
    - `DirectoryLister.java` manages the directory creation and listing logic.
- Graceful handling of invalid paths or directory reading errors.

---

## 💻 Technologies Used
- Java 17
- IntelliJ IDEA as the development environment

---

## 📋 Requirements
- Java Development Kit (JDK): Version 17 or higher.
- IDE: IntelliJ IDEA or any Java-compatible IDE.

---

## 🚀 Execution
### With Arguments:
1. Compile the project:
   ```bash
   javac -d out -sourcepath src src/Main.java

2. Run the program, providing the directory path as an argument:
    - If the directory does not exist, it is created automatically.
    - You can provide a relative or absolute path.
    - Relative path (in the project root):
       ```bash
         java -cp out Main TestFolder

   - Absolute path (for example, on the desktop):
   ```bash
    java -cp out Main /Users/ezequielmacchi_1/Desktop/TestFolder

### Without Arguments:
1. Run the program without arguments:
   - f no arguments are provided, the program automatically
     - Creates a folder called TestFolder in the project root (if it doesn't already exist).
     - Adds file1.txt, file2.txt y el subdirectorio subdir.
    ```bash
    java -cp out Main

### Example Output:
#### With Argument:
- Directory created at: /ruta/proporcionada/TestFolder
- Default files and subdirectory created.
- Contents of /ruta/proporcionada/TestFolder:
    - file1.txt
    - file2.txt
    - subdir

#### Without Argument:
- Directory created at: /ruta/a/TuProyecto/TestFolder
- Default files and subdirectory created.
- Contents of /ruta/a/TuProyecto/TestFolder:
  - file1.txt
  - file2.txt
  - subdir

---

## 🛠️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/eze-ms/Java-Utils-N1-E1