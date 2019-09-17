using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace NearbyShop.Models
{
    public class Shop
    {
        public Guid Id  { get; set; }
        [Required]
        public string name { get; set; }
        public int location { get; set; }
        public string adress { get; set; }
        public string image { get; set; }
        public string description { get; set; }
        public virtual ICollection<User> users { get; set; }
        public Shop()
        {
            this.users = new HashSet<User>();
        }

    }
}
