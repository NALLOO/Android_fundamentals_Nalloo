package com.example.gmail;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Inbox> inboxList = new LinkedList<>();
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private InboxAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();


        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new InboxAdapter(this, inboxList);
        recyclerView.setAdapter(adapter);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);

        setSupportActionBar(toolbar);
    }

    private void addData() {
        inboxList.add(new Inbox("GitHub", "[GitHub] A personal access token has been added to your account", "A personal access token (update assignment) with gist, read:org, repo, and workflow scopes was recently added to your account. Visit https://github.com/settings/tokens for more information.To see this and other security events for your account, visit https://github.com/settings/security-log  If you run into problems, please contact support by visiting https://github.com/contactThanks,The GitHub Team", "4:00 PM", false));
        inboxList.add(new Inbox("Codeforces", "Codeforces Round 798 (Div. 2)", "I'm glad to invite you to take part in Codeforces Round 798 (Div. 2). It starts on Friday, June, 10, 2022 16:35 (UTC). The contest duration is 2 hours. The allowed programming languages are C/C++, Pascal, Perl, Java, C#, Python (2 and 3), Ruby, PHP, Haskell, Scala, OCaml, D, Go, JavaScript and Kotlin", "May 30", false));
        inboxList.add(new Inbox("Spotify", "Premium, mi???n ph?? trong 1 th??ng. Ch??ng t??i ??ang mu???n trao ??i.", "T???i xu???ng playlist c???a b???n v?? nghe offline ????? ti???t ki???m dung l?????ng. T???n h?????ng t??nh n??ng b??? qua kh??ng gi???i h???n, ngay c??? tr??n thi???t b??? di ?????ng, v?? t??m ki???m nh???ng g?? b???n mu???n nghe. Ngo??i ra, nghe b???n nh???c b???t k??? b???n mu???n tr??n m???i thi???t b??? v???i t??nh n??ng nghe nh???c theo y??u c???u. V?? nghe t???t c??? nh???c c???a b???n kh??ng qu???ng c??o, ????? b???n c?? th??? tho???i m??i th?????ng th???c m?? kh??ng b??? gi??n ??o???n.", "May 28", true));
        inboxList.add(new Inbox("Dribbble ", "Get more eyes on your portfolio", "Experience limitless creation solutions and design freely on a fully-customizable canvas. Simplify the feedback process with integrated collaboration tools, all backed by infrastructure trusted for performance, reliability and security.", "May 20", false));
        inboxList.add(new Inbox("Baemin", "[BAEMIN] Vui l??ng x??c nh???n ?????a ch??? email c???a b???n", "H??y nh???n n??t d?????i ????? x??c th???c email nh??!", "May 1", true));
        inboxList.add(new Inbox("Figma", "Forgot your password?", "To reset your password, click the button below. The link will self-destruct after three days.", "Apr 28", true));
        inboxList.add(new Inbox("MoMo ", "Thi???t l???p thanh to??n th??nh c??ng cho d???ch v??? Gojek", "Ch??o PH???M ????NH NGH??A,B???n ???? thi???t l???p th??nh c??ng V?? MoMo 0961***201 ????? thanh to??n d???ch v??? Gojek. T??? nay, c??c thanh to??n cho d???ch v??? Gojek s??? ???????c t??? ?????ng tr??? ti???n qua c??c t??i kho???n thanh to??n trong V?? MoMo c???a b???n.", "Apr 20", false));
        inboxList.add(new Inbox("Discord ", "Important policy updates coming to Discord ",
                "Hey there,Some important changes are coming to Discord: we???re updating our Terms of Service, Privacy Policy, and Community Guidelines.", "Apr 15", false));
    }

}