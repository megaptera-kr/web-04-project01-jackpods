import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//public class SignUpPanel extends JPanel {
//    File file = new File("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/MemberDB.txt");
//    FileWriter fileWriter;
//    {
//        try {
//            fileWriter = new FileWriter(file, true);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        if (file.isFile() &&file.canWrite()) {
//                this.add(new JLabel("회원가입을 위해 ID와 비밀번호를 입력하세요"));
//                this.add(new JLabel("ID 입력 : "));
//                JTextField idTextField = new JTextField(10);
//                this.add(idTextField);
//
//                this.add(new JLabel("비밀번호 입력 : "));
//
//                JTextField passWordTextField = new JTextField(10);
//                this.add(passWordTextField);
//
//                JButton completeButton = new JButton("확인");
//                this.add(completeButton);
//
//                completeButton.addActionListener(event->{
//
//                    try {
//                        fileWriter.append((CharSequence) idTextField);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//
////                    fileWriter.append((CharSequence) passWordTextField);
//
//                });
//            }
//    }
//}
