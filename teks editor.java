package linked.list;

import java.util.Scanner;

public class LinkedList{

    class node {
    String huruf;
    node next;
    node prev;
        public void insert(String huruf){
            this.huruf=huruf;
        }
        public String getHuruf(){
         return this.huruf;
        }
    
}

    
    node head=null,tail=null,baru,temp,cetak;
    node del,after,before=null;
    
    public void tambah(){
        System.out.print("ketik 1 karakter\t:");
        Scanner input = new Scanner (System.in);
        String huruf;
        huruf = input.next();
        baru = new node();
        baru.insert(huruf);
        
        baru.next=null;
    
        if(head==null){
        head=baru;
        tail=baru;
        temp=baru;
        head.next=null;
        before=new node();
        head.prev=before;
        before.next=head;
        before.prev=null;
        }
        
        else if (temp.next==null){
        temp.next=baru;
        tail=baru;
        tail.prev=temp;
        temp=baru;
        }
        
        else if (temp.prev==null){
        head.prev=baru;
        before.next=baru;
        baru.prev=before;
        baru.next=head;
        head=baru;
        temp=head;
        before.prev=null;
        }
        
        else{
        after=temp.next;
        temp.next=baru;
        after.prev=baru;
        baru.next=after;
        baru.prev=temp;
        temp=baru;
        }
        
        System.out.println("");
    }
    
    
    void hapus(){
        if(temp==before)
        {
         System.out.print("\ntidak ada yang dihapus\n");
        }
        else if(head==tail)
        {
            del=head;
            temp=before;
            System.out.print("\nkarakter " +del.getHuruf()+" sudah dihapus\n");
            del=null;
            head=null;
        }
        
        else if(temp.next==null)
        {
            tail=tail.prev;
            del=temp;
            temp=temp.prev;
            System.out.print("\nkarakter "+del.getHuruf()+" sudah dihapus\n");
            del=null;
            tail.next=null;
        }
        else if(temp==head)
        {
            del=head;
            temp=before;
            head=head.next;
            System.out.print("\nkarakter "+del.getHuruf()+" sudah dihapus\n");
            del=null;
            temp.next=head;
            head.prev=before;
        }
        else
        {
            del=temp;
            temp=temp.prev;
            del.next.prev=temp;
            temp.next=del.next;
            System.out.print("\nkarakter "+del.getHuruf()+" sudah dihapus\n");
            del=null;
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void left()
    {
        if(temp==before)
        {
            System.out.print("\npointer sudah paling kiri\n");
        }
        else
        {
        System.out.print("\npointer telah digeser ke kiri\n");
        temp=temp.prev;
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void right()
    {
        if(temp==tail)
        {
            System.out.print("\npointer sudah paling kanan\n");
        }
        else
        {
            System.out.print("\npointer telah digeser ke kanan\n");
            temp=temp.next;
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void print()
    {
        if(head!=null)
        {
            cetak=head;
            while(cetak!=null)
            {
                System.out.print(cetak.getHuruf());
                cetak=cetak.next;
            }
        }
        else
        {
            System.out.print("\n(kosong)\n");
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
     public static void main(String[] args){
        LinkedList akses = new LinkedList();
        int a,i,pilih;
        System.out.println("\t\tProgram Mengetik");
        System.out.print("Masukkan jumlah perintah:");
        Scanner input = new Scanner (System.in);
        a = input.nextInt();
        for(i=0;i<a;i++)
        {
            System.out.print("ke-"+(i+1)+"\nMenu\t:\n");
            System.out.print("1.insert\n2.delete\n3.shift left\n4.shift right\n5.print\n");
            System.out.print("pilih\t:");
            Scanner pil = new Scanner (System.in);
            pilih = pil.nextInt();
            switch(pilih)
            {
                case 1:akses.tambah();
                break;
                case 2:akses.hapus();
                break;
                case 3:akses.left();
                break;
                case 4:akses.right();
                break;
                case 5:akses.print();
                break;
                default: System.exit(0);
            }
        }
    }
}
