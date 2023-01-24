package hr.algebra.nasa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import hr.algebra.nasa.adapter.EmployeeAdapter
import hr.algebra.nasa.adapter.SubjectAdapter
import hr.algebra.nasa.adapter.ViewPagerAdapter
import hr.algebra.nasa.databinding.FragmentInstitutionBinding
import hr.algebra.nasa.model.Employee
import hr.algebra.nasa.model.Subject

class InstitutionFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding: FragmentInstitutionBinding
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var employeeAdapter: EmployeeAdapter
    lateinit var subjectAdapter: SubjectAdapter
    lateinit var listImages: List<Int>
    private var listEmployee = ArrayList<Employee>()
    private var listSubject = ArrayList<Subject>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstitutionBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.idViewPager.findViewById<ViewPager>(R.id.idViewPager)
        fillImageList()

        viewPagerAdapter = ViewPagerAdapter(requireContext(), listImages)
        binding.idViewPager.adapter = viewPagerAdapter
        setEmployeesRecycleView()
        setSubjectRecycleView()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setEmployeesRecycleView() {
        binding.recycleView.findViewById<RecyclerView>(R.id.recycleView)
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        addDataToEmployeeRecycleView()
        employeeAdapter = EmployeeAdapter(listEmployee)
        binding.recycleView.adapter = employeeAdapter
    }

    private fun setSubjectRecycleView() {
        binding.recycleViewSubject.findViewById<RecyclerView>(R.id.recycleViewSubject)
        binding.recycleViewSubject.layoutManager = LinearLayoutManager(requireContext())
        addDataToSubjectRecycleView()
        subjectAdapter = SubjectAdapter(listSubject)
        binding.recycleViewSubject.adapter = subjectAdapter
    }

    private fun addDataToSubjectRecycleView() {
        listSubject.add(Subject("Programsko inženjerstvo", "Po završetku studija, imat ćeš sva potrebna znanja o programskom inženjerstvu, ovladat ćeš glavnim objektno orijentiranim jezicima .NET i JAVA, naučit ćeš programirati, razvijati i održavati složene aplikacije i informacijske sustave. U kojem god od ovih segmenata vidiš svoju budućnost, s Algebrinom diplomom joj zasigurno krećeš ususret s vjetrom u leđa."))
        listSubject.add(Subject("Sistemsko inženjerstvo", "Po završetku studija, znat ćeš sve što je potrebno za primjenjivanje i održavanje složenih informacijskih sustava koji se zasnivaju na najsuvremenijoj tehnologiji današnjice. Trogodišnji stručni prijediplomski studij sistemskog inženjerstva daje ti vještine i znanja pomoću kojih ćeš moći izgraditi karijeru u stvarnom svijetu IT sistemskog inženjerstva bilo gdje u svijetu."))
        listSubject.add(Subject("Računalna multimedija", "Po završetku studija, znat ćeš kako najbolje uklopiti medijske tehnologije u svaki projekt, te kako savladati nabolje prakse u stvaranju multimedijskog sadržaja"))
        listSubject.add(Subject("Digitalni marketing", "Digitalni marketing sve više postaje jedno od najtraženijih područja ekonomije, što znači da s diplomom iz digitalnog marketinga sigurno nećeš dugo tražiti posao. Stručni prijediplomski studij digitalnog marketinga studentima omogućuje niz prednosti"))
    }

    private fun addDataToEmployeeRecycleView() {
        listEmployee.add(Employee("Daniel Bele", R.drawable.dbele, "Predavač", "Daniel Bele, struč.spec.ing.comp., rođen je 1975. u Zagrebu. Završio je diplomski studij programskog inženjerstva na Visokom učilištu Algebra. Prije i tijekom obrazovanja i rada stekao je Oracle (5), Microsoft (3), ATC (2) i Itil certifikate. Predavač je i asistent je na Visokom učilištu Algebra te nastavnik na Otvorenom učilištu Algebra. Profesionalno se bavio programiranjem u trajanju od 10 godina, od čega je 8.5 godina proveo u tvrtci Interactive1. Radio je na brojnim projektima, pretežito u Java tehnologiji, za englesko i talijansko tržište. Na projektima se bavio WEB tehnologijom (client i server side) te Androidom. Zanosi se književnošću te je izdao roman i zbirku priča. Bavio se i novinarstvom te je 2 godine bio kolumnist portala SEEbiz.eu, kao i radio voditelj emisije na Radio Trsat u Rijeci u trajanju od godinu dana."))
        listEmployee.add(Employee("Danijel Kučak", R.drawable.dkucak, "Predavač", "Danijel Kučak je rođen 1978. godine u Zagrebu, gdje je i diplomirao na matematičkom odsjeku Prirodoslovno-matematičkog fakulteta. Trenutno pohađa doktorski studij Informacijskih znanosti na Fakultetu Organizacije i Informatike. 2006. godine asistirao je na kolegiju Informatika na Edukacijsko rehabilitacijskom fakultetu. Od 2007. godine do danas je zaposlen kao predavač na Visokom Učilištu Algebra. Višestruki je dobitnik nagrade za najboljeg predavača na Visokom Učilištu Algebra. Uža specijalnost mu je razvoj web aplikacija i web usluga temeljenih na platformama .NET (Web Forms i MVC.NET) i Java. Do sada je bio autor i koautor 5 knjiga na temu programiranja, a objavio je i desetak znanstvenih i stručnih radova na temu razvoja aplikacija. Od završetka studija do danas radi kao razvojni inženjer ili arhitekt na nekoliko informacijskih sustava od kojih posebno ističe: MyQTest – sustav za testiranje znanja, HAK e-ispiti – sustav za provođenje testiranja poznavanja pravila sigurnosti prometa, MedicalBit – BIS sustav implementiran u klinici za plućne bolesti Rockfellerova Zagreb, CRIS (Croatian Road Inspection System) – sustav za podršku inspekcijskog nadzora cestovnog prometa."))
        listEmployee.add(Employee("Aleksandar Radovan", R.drawable.aradovan, "Predavač", "Aleksander Radovan je 2021. godine doktorirao na Fakultetu elektrotehnike i računarstva u Zagrebu. Radi kao direktor razvoja u tvrtki BISS d.o.o., a osim toga radi kao predavač na nekoliko veleučilišta u Zagrebu i okolici na predmetima vezanim uz programski jezik Java i informacijske sustave općenito. Osim toga obnaša funkciju predsjednika Odbora za edukaciju u Hrvatskoj udruzi Java korisnika (HUJAK) te sudjeluje u programskim odborima vezanim za organiziranje Java konferencija u Hrvatskoj. Objavio je više od 60 stručnih i znanstvenih radova vezanih uz programiranje u Javi i vezane tehnologije. Bavi se i područjem umjetne inteligencije, genetskih algoritama, robotike i podučavanje programiranja mlađih generacija"))
    }

    private fun fillImageList() {
        listImages = ArrayList<Int>()
        listImages = listImages + R.drawable.algebradruga
        listImages = listImages + R.drawable.algebrajedan
        listImages = listImages + R.drawable.algebratreca
        listImages = listImages + R.drawable.algebracetvrta
    }

    override fun onMapReady(googleMap: GoogleMap) {

    }
}