/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.MemberBO;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author BJ
 */
public class MemberRegistration {
    private Member member;
    private String previousSurnames = "";

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    
    public String getPreviousSurnames() {
        return previousSurnames;
    }

    public void setPreviousSurnames(String previousSurnames) {
        this.previousSurnames = previousSurnames;
    }

}


