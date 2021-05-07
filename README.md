# UniWork2021

Just a safe place to backup some files


notes:

Scanner scanner = new Scanner(a);
            boolean flag = false; 
            boolean found = false;
            
            String title;
            String author;
            String content = "";
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            
                if (line.contains("Title:")) {
                    title = line.substring(7);
                    found = true;
                    bookInfo.put("Title", title);
                
                } if (line.contains("Author:")) {
                    author = line.substring(8);
                    bookInfo.put("Author", author);
                
                } if (line.contains("*** START")) {
                    flag = true;
                
                } if (flag) {
                    content += line;
                    bookInfo.put("Content", content); 
                }  
            } 
            if (!found) {
                throw new IOException();
            }
LinkedList<Book> linkedList = new LinkedList<>();