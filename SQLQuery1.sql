-- MAN HINH GV XEM DIEM CUA SINH VIEN TRONG 1 LOP CUA 1 MON HOC--

--LOAD tu Database cac lop hoc--
SELECT CLID, CLName FROM Class
--LOAD tu Database cac mon hoc--
SELECT CID, Cname FROM Course
--LOAD diem cua cac hoc sinh
SELECT A.SID, [Name], [PT1], [PT2], [WS1], [WS2], [PE], [ASM],[FE] FROM Student A JOIN [StudentGroup] B ON
A.SID = B.SID
JOIN [Group] C
ON B.GID = C.GID
JOIN [StudentMark] D
ON A.SID = D.SID
JOIN [Mark] E
ON E.MKID = D.MKID
JOIN [Class] F
ON F.CLID = C.CLID
JOIN [GroupCourse] G
ON G.GID = C.GID
JOIN [Course] H
ON H.CID = G.CID
Where C.GID = '1' and E.CID= '1'

--MAN HINH CHINH SUA DIEM CUA MOT HOC SINH DUOC CHON--
SELECT A.SID, A.Name, H.Cname,F.CLName, [PT1], [PT2], [WS1], [WS2], [PE], [ASM],[FE] FROM Student A JOIN [StudentGroup] B ON
A.SID = B.SID
JOIN [Group] C
ON B.GID = C.GID
JOIN [StudentMark] D
ON A.SID = D.SID
JOIN [Mark] E
ON E.MKID = D.MKID
JOIN [Class] F
ON F.CLID = C.CLID
JOIN [GroupCourse] G
ON G.GID = C.GID
JOIN [Course] H
ON H.CID = G.CID
WHERE A.SID ='HE163011'

--MAN HINH CHINH SUA DIEM CUA CA LOP--

--LOAD ten lop
SELECT CLName FROM Class

--Load ten mon hoc
SELECT Cname FROM Course
-- load diem tu database
SELECT  A.SID, [Name], [PT1], [PT2], [WS1], [WS2], [PE], [ASM],[FE] FROM Student A JOIN [StudentGroup] B ON
A.SID = B.SID
JOIN [Group] C
ON B.GID = C.GID
JOIN [StudentMark] D
ON A.SID = D.SID
JOIN [Mark] E
ON E.MKID = D.MKID
JOIN [Class] F
ON F.CLID = C.CLID
JOIN [GroupCourse] G
ON G.GID = C.GID
JOIN [Course] H
ON H.CID = G.CID
Where C.GID = '1' and E.CID= '1'